package cn.wolfcode.luowowo.website.web.controller;

import cn.wolfcode.luowowo.article.domain.Destination;
import cn.wolfcode.luowowo.article.service.IDestinationService;
import cn.wolfcode.luowowo.cache.domain.AnswerStatisVO;
import cn.wolfcode.luowowo.cache.service.IAnswerStatisVOService;
import cn.wolfcode.luowowo.comment.domain.Answer;
import cn.wolfcode.luowowo.comment.domain.Question;
import cn.wolfcode.luowowo.comment.service.IQuestionService;
import cn.wolfcode.luowowo.common.exception.LogicException;
import cn.wolfcode.luowowo.common.util.AjaxResult;
import cn.wolfcode.luowowo.member.domain.UserInfo;
import cn.wolfcode.luowowo.website.web.annotation.UserParam;
import cn.wolfcode.luowowo.website.web.util.UMEditorUploader;
import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/wenda")
public class WendaController {

    @Reference
    private IQuestionService questionService;

    @Reference
    private IAnswerStatisVOService answerStatisVOService;

    @Reference
    private IDestinationService destinationService;

    @RequestMapping("")
    public String index(Model model, @UserParam UserInfo user, HttpSession session){
        System.out.println("hello word");
        session.setAttribute("user",user);//todo 拦截器中没有将用户的信息存到session中,所以先在这里存,但是是不合理的
        List<Question> questions = questionService.selectAll();
        for (Question question : questions) {
            List<Answer> list = question.getList();
            if (list.size() > 1) {
                List<Answer> answers = list.subList(0, 1);
                question.setList(answers);
            }
        }
        //查询出回答数的排行榜
        List<AnswerStatisVO> replyRank = answerStatisVOService.selectReplyRank();
        model.addAttribute("replyRank",replyRank);

        //查询出金牌数的排行榜
        List<AnswerStatisVO> medalRank = answerStatisVOService.selectMedalRankList();
        model.addAttribute("medalRank",medalRank);

        //查询出顶数量的排行榜
        List<AnswerStatisVO> thumbsupRank = answerStatisVOService.selectThumbsupRankList();
        model.addAttribute("thumbsupRank",thumbsupRank);
        model.addAttribute("questions",questions);
        return "wenda/wenda";
    }


    @RequestMapping("/public")
    public String publish(Model model){
        List<Destination> dests = destinationService.getDestsByDeep(3);
        model.addAttribute("dests",dests);
        return "wenda/public";
    }

    @RequestMapping("/wendaDetail")
    public String  wendaDetail(String id,Model model,@UserParam UserInfo userInfo){
        Question question = questionService.selectById(id);
        model.addAttribute("question",question);
        model.addAttribute("userInfo",userInfo);
        return "wenda/wendaDetail";
    }



    /**
     * 提交问题
     * @param question
     * @param userInfo
     * @return
     */
    @RequestMapping("/save")
    @ResponseBody
    public Object save(Question question, @UserParam UserInfo userInfo){
        //将用户信息存到这个对象当中
        if(userInfo == null){
            throw new LogicException("请先登录之后在执行发表!!");
        }
        if(question != null){
            question.setUserId(userInfo.getId());
            question.setCity(userInfo.getCity());
            question.setUsername(userInfo.getNickname());
            question.setLevel(userInfo.getLevel());
            question.setHeadUrl(userInfo.getHeadImgUrl());
            Destination dest = destinationService.getById(question.getDestId());
            question.setDestName(dest.getName());
        }
        String id = questionService.save(question);
        return AjaxResult.SUCCESS.addData(id);
    }


    //上传图片
    @Value("${file.path}")
    private String filePath;
    @RequestMapping("/contentImage")
    @ResponseBody
    public String uploadUEImage(MultipartFile upfile, HttpServletRequest request) throws Exception{
        UMEditorUploader up = new UMEditorUploader(request);
        String[] fileType = {".gif" , ".png" , ".jpg" , ".jpeg" , ".bmp"};
        up.setAllowFiles(fileType);
        up.setMaxSize(10000); //单位KB
        up.upload(upfile, filePath);

        String callback = request.getParameter("callback");
        String result = "{\"name\":\""+ up.getFileName() +"\", \"originalName\": \""+ up.getOriginalName() +"\", \"size\": "+ up.getSize()
                +", \"state\": \""+ up.getState() +"\", \"type\": \""+ up.getType() +"\", \"url\": \""+ up.getUrl() +"\"}";
        result = result.replaceAll( "\\\\", "\\\\" );
        if(callback == null ){
            return result ;
        }else{
            return "<script>"+ callback +"(" + result + ")</script>";
        }
    }


    /**
     * 保存回答的内容
     */
    @RequestMapping("/saveAnswer")
    @ResponseBody
    public Object saveAnswer(Answer answer,String questionId,@UserParam UserInfo userInfo){
        if(userInfo != null){
            answer.setLevel(userInfo.getLevel());
            answer.setHeadUrl(userInfo.getHeadImgUrl());
            answer.setUsername(userInfo.getNickname());
            answer.setCity(userInfo.getCity());
            answer.setUserId(userInfo.getId());
            answer.setReplytime(new Date());
            if(answer.getContent().length()>150){
                answer.setSummary(answer.getContent().substring(0,150));
            }else{
                answer.setSummary(answer.getContent());
            }
        }
        String id = questionService.saveAnswerByQuestionIdToList(answer,questionId);
        return AjaxResult.SUCCESS.addData(id);
    }


    @RequestMapping("/answerThumbsup")
    @ResponseBody
    public Object answerThumbsup(long userId,String answerId){
        answerStatisVOService.thumbsupnumIncrease(answerId,userId,1);
        return AjaxResult.SUCCESS;
    }

}
