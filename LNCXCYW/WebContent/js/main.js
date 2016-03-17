/*
 *首页相关的js 
 */
function setTabsnow(name,cursel,n){
 for(i=1;i<=n;i++){
  var menu=document.getElementById(name+i);
  var con=document.getElementById("con_"+name+"_"+i);
  var consnow=document.getElementById("con_snow_"+name+"_"+i);
  menu.className=i==cursel?"curnews":"";
  con.style.display=i==cursel?"block":"none";
 // consnow.style.display=i==cursel?"block":"none";
 }
 
 
}