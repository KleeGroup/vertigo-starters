<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<!DOCTYPE html>
<html>
	<head>
		<title>${appName}</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<sj:head compressed="false" jquerytheme="redmond" locale="fr" jqueryui="true" loadAtOnce="true"/>
		<link href="static/css/bootstrap.min.css" rel="stylesheet" type="text/css" media="all" />
		<link href="static/css/bootstrap-theme.min.css" rel="stylesheet" type="text/css" media="all" />
		<link href="static/css/${projectName}.css" rel="stylesheet" type="text/css" media="all" />
	</head>
	<body>

		<div id="popin" class="modal hide fade modalWrapper modalConfirm"  role="dialog" data-keyboard="false" data-backdrop="static" >
			<div class="modal-header">
				<h1>Demande de confirmation</h1>
			</div>
			<div class="modal-body">
				<p>Etes-vous certain de vouloir continuer?</p>
			</div>
			<div class="modal-footer">
				<a href="#" class="btn fermer" >Non</a>
				<a href="#" class="btn btn-primary valider"id="confirmOk">Oui</a>
			</div>
		</div>
		<div id="popin-overlay" class="popin-overlay modal-backdrop fade in modalConfirmOverrlay" ></div>
		<%@include file="/WEB-INF/jsp/include/popin.jsp" %>
