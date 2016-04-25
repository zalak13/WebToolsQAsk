<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html>
<html>
<head>
<tiles:insertAttribute name="title" ignore="true" />
<link rel="stylesheet" type="text/css" href="resources/css/layoutstyle.css" />
</head>
<body>
    <div id="wrapper">
        <div id="navigationwrap">
        <div id="navigation">
            <tiles:insertAttribute name="menu" />
        </div>
        </div>
        <div id="contentliquid"><div id="contentwrap">
        <div id="content">
           <p><tiles:insertAttribute name="body" /></p>
        </div>
        </div></div>
        <div id="leftcolumnwrap">
        <div id="leftcolumn">
            <tiles:insertAttribute name="leftcolumn" />
        </div>
        </div>
        <div id="rightcolumnwrap">
        <div id="rightcolumn">
            <tiles:insertAttribute name="rightcolumn" />
        </div>
        </div>
    </div>
</body>
</html>