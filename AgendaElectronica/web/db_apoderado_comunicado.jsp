<jsp:include page="header.jsp"></jsp:include>

<div class="row">
    <jsp:include page="menu.jsp"></jsp:include>

    <div class="col m9 s12">
        <ul id="tabs-swipe-demo" class="tabs">
            <li class="tab col s3"><a href="#test-swipe-1">Test 1</a></li>
            <li class="tab col s3"><a href="#test-swipe-2">Test 2</a></li>
            <li class="tab col s3"><a href="#test-swipe-3">Test 3</a></li>
        </ul>
        <div id="test-swipe-1" class="col s12">
            <ul class="collapsible" data-collapsible="accordion">
                <li>
                    <div class="collapsible-header">First</div>
                    <div class="collapsible-body"><span>Lorem ipsum dolor sit amet.</span></div>
                </li>
                <li>
                    <div class="collapsible-header">Second</div>
                    <div class="collapsible-body"><span>Lorem ipsum dolor sit amet.</span></div>
                </li>
                <li>
                    <div class="collapsible-header">Third</div>
                    <div class="collapsible-body"><span>Lorem ipsum dolor sit amet.</span></div>
                </li>
            </ul>
        </div>
        <div id="test-swipe-2" class="col s12">Test 2</div>
        <div id="test-swipe-3" class="col s12">Test 3</div>
    </div>


</div>

<jsp:include page="footer.jsp"></jsp:include>