$(document).ready(function(){
   $('.button-collapse').sideNav({
       edge: 'right'
   });

   $('ul.tabs').tabs();

   $('.collapsible').collapsible();

   $('.slider').slider({
        interval: 3000
    });
});


