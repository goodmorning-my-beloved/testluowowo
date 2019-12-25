<#list hotelScore as hs>
<ul class="clearfix" style="display: block;" data-id="0">

    <li data-id="84968" data-mddid="11045" data-youyu-id="8062" data-ota-id="5">
        <a href="${hs.url!}" target="_blank" data-type="hotel" data-name="${hs.name}">
            <div class="pic">
                <img src="${hs.img}" class="img-show">
            </div>
            <div class="bag-opa"></div>
            <div class="fraction">${hs.score}分</div>
            <div class="info">
                <div class="prize"></div>
                <p>${hs.shortName}</p>
                <p class="eng">${hs.name}</p></div>
        </a>
    </li>
</#list>
</ul>