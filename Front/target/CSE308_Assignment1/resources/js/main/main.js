  function scrollDiv(dir, px) {
        var scroller = document.getElementById('scroller');
        if (dir == 'l') {
            scroller.scrollLeft -= px;
        }
        else if (dir == 'r') {
            scroller.scrollLeft += px;
        }
    }
  
  function enterClicked() {
		/*document.welcomeform.action = "recommendation2.action";
		document.welcomeform.submit();*/
	  window.location.href="recommendation0.action?number=2";
  }
  var prevItem = null;
  function activateItem(t){
     if(prevItem != null){
        prevItem.className = prevItem.className.replace(/{\b}?activeItem/, "");
     }
     t.className += " activeItem";
     prevItem = t;
  }
  function logoutClicked() {
		document.homeform.action = "logout.action";
		document.homeform.submit();
}
  
