var replyService = (function() {

	var idx = 0;
	
	/*var csrfHeaderName = "${_csrf.headerName}";
	var csrfTokenValue =  "${_csrf.token}";*/
	
	const host = "/replies_com/";

	function removeReply(rno, callback) {
		$.ajax({
			type : "delete",
			url : host+"remove/"+rno,
			success : function() {
				if (callback) {
					callback();
				}
			}
		})
	}
	function modifyReply(obj, callback) {
		$.ajax({
			type : "put",
			url : host + "modify",
			data : JSON.stringify(obj),
			contentType : "application/json;charset=UTF-8",

			success : function() {
				console.log("실행성공");
				if (callback) {
					callback();
				}
			}
		})
	}


	function addReply(obj, callback) {
		$.ajax({
			type : "post",
			url : host + "new",
			data : JSON.stringify(obj),
			contentType : "application/json;charset=UTF-8",
			success : function() {
				if (callback) {
					callback();
				}
			}
		})
	}


	function getListPage(param, callback) {
		var bno = param.bno;
		var page = param.page || 1;
		
		$.getJSON(host + bno + "/" + page, null, function(arr) {
			if (callback) {
				callback(arr);
			}
		})
	}
	function getList(bno, callback) {
		$.getJSON(host + "list/" + bno, null, function(arr) {
			if (callback) {
				callback(arr);
			}
		})
	}

	function getReply(rno, callback) {
		$.getJSON(host + rno, null, function(arr) {
			if (callback) {
				callback(arr);
			}
		})
	}

	return {
		addReply : addReply,
		modifyReply : modifyReply,
		removeReply : removeReply,
		getList : getList,
		getListPage: getListPage,
		getReply : getReply
	}

})();