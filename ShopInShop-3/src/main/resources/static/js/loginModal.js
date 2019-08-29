var loginModal = (function() {

	var actionForm = $("#serachForm")
	var loginForm = $("#loginForm")

	function login() {
		$("#replyModal").modal('show')
	}

	$("#serch").on("click", function(e) {
		e.preventDefault();

		//alert($("#keyword").val())
		$("input[name='keyword']").val($("#keyword").val())
		serachForm.submit();

	})

	$("#loginButton").on("click", function(e) {

		loginForm.submit();
	})

	return {
		login:login
	}

})();