<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<style type="text/css">
.menu {
	width: 100%;
	margin: 0px;
	list-style: none;
}

.navbar {
	color: #999999;
}

.navbar {
	overflow: visible;
	margin-bottom: 18px;
}

.grey {
	color: #CCCCCC;
}

.dropdown-menu li.header,#search-x .dropdown-menu li.header {
	font-weight: bold;
	padding: 3px 5px;
}
ul,li{ padding:0; margin:0}
li{ list-style:none}
.dropdown_search03 span a,.dropdown_search04 span a,.dropdown_search05 span a,.dropdown_search01 span a { color: #005dab; text-decoration: underline;}
.dropdown_search{ background:url(${pageContext.request.contextPath}/jsp/box/images/icon01.jpg) 5px no-repeat; padding:3px 0px 0px 20px; font-weight:bold;}
.dropdown_search01{ margin-left:15px;}
.dropdown_search01:hover{ background:#d6e9f5;}
.dropdown_search01 a:hover,.dropdown_search02 a:hover,.dropdown_search03 a:hover,.dropdown_search04 a:hover,.dropdown_search05 a:hover{ background-image:none}
.dropdown_search02{ background:url(${pageContext.request.contextPath}/jsp/box/images/box_icon02.jpg) 5px no-repeat; padding:3px 0px 0px 25px; font-weight:bold;}
.dropdown_search03{ margin-left:5px; background:url(${pageContext.request.contextPath}/jsp/box/images/box_icon08.jpg) 5px no-repeat;padding:3px 0px 0px 25px;}
.dropdown_search03:hover{ margin-left:5px; background:url(${pageContext.request.contextPath}/jsp/box/images/box_icon08.jpg) 5px no-repeat #d6e9f5; padding:3px 0px 0px 25px;}
.dropdown_search04{ margin-left:5px;  background:url(${pageContext.request.contextPath}/jsp/box/images/boxtime.png) 5px no-repeat; padding:3px 0px 0px 25px;}
.dropdown_search04:hover{ margin-left:5px;  background:url(${pageContext.request.contextPath}/jsp/box/images/boxtime.png) 5px no-repeat #d6e9f5;  padding:3px 0px 0px 25px;}
.dropdown_search05{ margin-left:5px;  background:url(${pageContext.request.contextPath}/jsp/box/images/boxopen.png) 5px no-repeat; padding:3px 0px 0px 25px;}
.dropdown_search05:hover{ margin-left:5px;  background:url(${pageContext.request.contextPath}/jsp/box/images/boxopen.png) 5px no-repeat #d6e9f5;  padding:3px 0px 0px 25px;}

#search-x .dropdown-menu a {
	white-space: normal;
	font-weight: normal;
	 font-size: 12px;
}

#search-x .dropdown-menu {
	width: 308px;
	min-height: 200px;
	overflow-y: auto;
	max-height: 300px;
}

.dropdown { /*position: relative;*/
	
}

.dropdown-toggle {
	position: relative;
	*margin-bottom: -3px;
}

.dropdown-toggle:active,.open .dropdown-toggle {
	outline: 0;
}

.dropdown {
	margin-top: 8px;
	margin-left: 2px;
}

.dropdown-menu {
	position: absolute;
	top: 100%;
	left: 0;
	z-index: 1000;
	display: none;
	float: left;
	min-width: 160px;
	padding: 4px 0;
	margin: 1px 0 0;
	list-style: none;
	background-color: #ffffff;
	border: 1px solid #ccc;
	border: 1px solid rgba(0, 0, 0, 0.2);
	*border-right-width: 2px;
	*border-bottom-width: 2px;
	-webkit-border-radius: 5px;
	-moz-border-radius: 5px;
	border-radius: 5px;
	/*   -webkit-box-shadow: 0 5px 10px rgba(0, 0, 0, 0.2); */
	/*   -moz-box-shadow: 0 5px 10px rgba(0, 0, 0, 0.2); */
	/*   box-shadow: 0 5px 10px rgba(0, 0, 0, 0.2); */
	-webkit-background-clip: padding-box;
	-moz-background-clip: padding;
	background-clip: padding-box;
}

ul.dropdown-menu.pull-right {
	top: 93px;
	margin-left: -120px;
	left: auto;
	overflow-x:hidden;
}

.dropdown-menu li {
	list-style-type: none;
	text-align: left;
	width: 280px;
	line-height: 25px;
}

.open {
	*z-index: 1000;
}

.open .dropdown-menu {
	display: block;
}

.dropdown-menu:before {
	content: '';
	display: inline-block;
	border-left: 7px solid transparent;
	border-right: 7px solid transparent;
	border-bottom: 7px solid #ccc;
	border-bottom-color: rgba(0, 0, 0, 0.2);
	position: absolute;
	top: -7px;
	left: 9px;
}

.dropdown-menu:after {
	content: '';
	display: inline-block;
	border-left: 6px solid transparent;
	border-right: 6px solid transparent;
	border-bottom: 6px solid #ffffff;
	position: absolute;
	top: -6px;
	left: 10px;
}

</style>
<script type="text/javascript">
	$(document).ready(function(){
		
		var timerId = null,
        previousSearch = null;

    $("#hd_search input").focus(function(e) {
        var $this = $(this);

        if ($this.val() == "请输入关键词") {
            $this.val("");
        }
        $this.removeClass("grey");

        $('[data-toggle="dropdown"]').parent().removeClass('open');
    }).click(function(e) {
        e.stopPropagation();

    }).blur(function() {
        $(this)
            .val("请输入关键词")
            .addClass("grey");
    }).bind('keyup', function() {
        var $this = $(this),
            currentSearch = jQuery.trim($this.val());
        currentSearch == '' ? previousSearch == null:'';

        if (previousSearch === null || previousSearch != currentSearch) {
            window.clearTimeout(timerId);
            sPreviousSearch = $this.val();
            timerId = window.setTimeout(function() {
                doSearch($this);
            }, 1000);
        }
    });
    
    function doSearch($this) {
        var dropdown = $this.closest('.dropdown'),
            dropdownMenu = dropdown.children('.dropdown-menu');
    
        if (!dropdown.hasClass('open')) {
            dropdown.addClass('open');
        }

        dropdownMenu.html('<li class="header">Loading...</li>');
      	dropdownMenu.load(
            '${pageContext.request.contextPath}/casesAction/default/search.do?q=' + encodeURIComponent(jQuery.trim($this.val())),
            function(text, status, xhr) {
                if (status == "error") {
                    dropdownMenu.html('<li class="header">Error loading results</li>');
                }
            }
        );
    }
    
    $(document).on(
			'click',
			function(e) {
				if ($('.dropdown-menu pull-right').is(e.target)
						|| $('.dropdown-menu pull-right').has(e.target).length) {
					return;
				}
				$('#search-x').removeClass('open');

			});
    
	});
</script>
<ul class="menu navbar">
	<li class="top_b_right_a dropdown" id="search-x">
	<form action="${pageContext.request.contextPath}/casesAction/default/search.do" method="get" id="hd_search" class="grey dropdown-toggle" data-toggle="dropdown" accept-charset="utf-8">
		<span class="top_b_right_a_left">
			<input type="text" name="q" value="请输入关键词" class="grey" title="通过患者的姓、名或订单号查询" autocomplete="off">
		</span> 
		<span class="top_b_right_a_right">
			<img alt="" src="${pageContext.request.contextPath}/jsp/u_lab/images/u_lab_07.jpg" style="cursor: pointer;">
		</span>
	</form>
	<ul class="dropdown-menu pull-right">
	
	</ul>
	</li>
	<li><a href="javascript:void(0)">帮助</a></li>
</ul>
