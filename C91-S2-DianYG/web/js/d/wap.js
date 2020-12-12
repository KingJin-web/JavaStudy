try {
var urlhash = window.location.hash;
if (!urlhash.match("fromapp"))
{
if ((navigator.userAgent.match(/(iPhone|Android|ios)/i)))
{
window.location="https://www.dygang.org";
}
}
}
catch(err)
{
}
