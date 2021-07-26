var pagingObj = {};

(function(){
    pagingObj.dataPerPage = 10;     // 한 페이지에 나타낼 데이터 수
    pagingObj.pageCount = 10;       // 한 화면에 나타낼 페이지 수
    pagingObj.prev = 0;             // 이전 페이지 값
    pagingObj.next = 0;             // 다음 페이지 값
    pagingObj.windowWidth = 530;    // 모바일 / PC 확인을 위한 window size

    /**
     * 페이징 처리
     * @param target       = 처리한 페이징 내용을 넣을 대상
     * @param totalDataCnt = 전체 데이터 개수
     * @param pagingData   = 데이터 리스트
     * @param currentPage  = 현쟂 페이지 번호
     * @param callback     = callback 함수
     */
    window.paging = window.customPaging = function(target, totalDataCnt, pagingData, currentPage, callback){
        var windowSize = window.innerWidth; // PC / 모바일 구분을 위한 윈도우 사이즈 측정

        if(windowSize >= pagingObj.windowWidth) pcPaging(target, totalDataCnt, currentPage); // PC 페이징 처리
        else mobileMoreView(target, totalDataCnt, pagingData, currentPage);  // MOBILE 더보기 처리

        // 페이징 클릭 이벤트
        $(target + ' a').on('click',function(){
            var thisItem = $(this), thisId = thisItem.attr('id'), currPage, pageSize, section;

            if(thisId === 'viewMore'){ // 모바일 더보기
                thisId = thisItem.attr('title');
                currPage = parseInt(thisId) * pagingObj.dataPerPage + 1;
                pageSize = currPage + (pagingObj.dataPerPage - 1);
                section = 'MOBILE';

            } else {    // PC 페이징
                if(thisId === 'next') currPage = pagingObj.next;
                else if(thisId === 'prev') currPage = pagingObj.prev;
                else currPage = parseInt(thisItem.text());

                pageSize = currPage * pagingObj.dataPerPage;
                currPage = currPage * pagingObj.dataPerPage - (pagingObj.dataPerPage - 1);
                section = 'PC';
            }

            //window[callback](currPage, pageSize, section); // 콜백 실행 (ECMAScript 6 이상 사용)
            new Function('return '+callback+'(\''+currPage +'\', \''+ pageSize +'\', \''+section+'\')')()   // 콜백 실행
        });
    };

    var pcPaging = function(target, totalDataCnt, currentPage){
        // 현재 페이지 A tag ID
        curPageId = currentPage>1?Math.round((currentPage/pagingObj.dataPerPage))+1:currentPage;
        
        // 총 페이지 수
        var totalPage = Math.ceil(totalDataCnt/pagingObj.dataPerPage);
        
        // 페이지 그룹
        var pageGroup = Math.ceil(curPageId/pagingObj.pageCount);

        // 화면에 보여질 마지막 페이지 번호
        var last = pageGroup * pagingObj.pageCount;

        // 마지막 페이지 번호가 총 페이지 수 보다 많으면 총 페이지 수 세팅
        if(last > totalPage) last = totalPage;

        // 화면에 보여질 첫번째 페이지 번호
        var first = last - (pagingObj.pageCount-1);

        // 첫페이지가 1보다 작을 경우 1로 세팅
        if(first < 1) first = 1;

        pagingObj.next = last + 1;
        pagingObj.prev = first - 1;

        var pagingHtml = "";

        if(pagingObj.prev > 0) pagingHtml += '<a href="javascript:void(0)" class="prev" id="prev">이전</a>';

        pagingHtml += '<ol>';

        for(var i = first; i <= last; i++){
            pagingHtml += '<li id="'+i+'"><a href="javascript:void(0)" id="pcPaging">'+ i +'</a></li>';
        }

        pagingHtml += '</ol>';

        if(last < totalPage) pagingHtml += '<a href="javascript:void(0)" class="next" id="next">다음</a>';

        // 페이지 목록 생성
        $(target).html(pagingHtml);    
        $(target).addClass('num');  // TODO : 각 프로젝트 스타일에 맞게 수정 및 삭제 필요
        
        // 현재 페이지 표시
        $(target + ' li#'+curPageId).addClass('curpage');  // TODO : 각 프로젝트 스타일에 맞게 수정 및 삭제 필요

        // 데이터 없을 경우 페이징 삭제 처리
        if(totalDataCnt > 0) $(target).show();
        else $(target).hide();
    };

    var mobileMoreView = function(target, totalDataCnt, pagingData, currentPage){
        // 스크롤 세팅
        moreScrollTop = document.documentElement.scrollTop;
        
        // 현재 페이지 num 처리 ( 1, 2, 3, 4.... )
        currentPage = parseInt(Math.round((currentPage/(pagingObj.dataPerPage - 1)))+1);
        
        // 마지막 페이지 번호
        var lastPage = totalDataCnt%pagingObj.dataPerPage===0?Math.round(totalDataCnt/pagingObj.dataPerPage):Math.round(totalDataCnt/pagingObj.dataPerPage)+1;

        var pagingHtml = '<a href="javascript:void(0)" class="viewMore" id="viewMore" title="'+ currentPage +'"><span>'+ moreViewTtle +'</span></a>';

        // 페이지 목록 생성
        $(target).html(pagingHtml);

        // 데이터 없을 경우와 마지막 페이지일 경우 페이징 삭제 처리
        if(totalDataCnt > 0 && lastPage !== currentPage) $(target).show();
        else $(target).hide();
    };
})(window);