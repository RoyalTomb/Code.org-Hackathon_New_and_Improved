//Variables

//Top 200 Worldwide
var trackName01 = getColumn("Top 200 Worldwide", "Track Name");
var artist01 = getColumn("Top 200 Worldwide", "Artist");
var position01 = getColumn("Top 200 Worldwide", "Position");
var trackName01Index = 0;
var artist01Index = 0;
var position01Index = 0;
//Top 200 USA
var trackName02 = getColumn("Top 200 USA", "Track Name");
var artist02 = getColumn("Top 200 USA", "Artist");
var position02 = getColumn("Top 200 USA", "Position");
//Songs/Artists List + Viral 50 List 
var trackName03 = getColumn("Viral 50 Worldwide", "Track Name");
var artist03 = getColumn("Viral 50 Worldwide", "Artist");
var position03 = getColumn("Viral 50 Worldwide", "Position");
var trackName03Index = 0;
var artist03Index = 0;
var position03Index = 0;

//Making the traverse screen buttons work
onEvent("screenR01", "click", function( ) {
  setScreen("screenTop200USA");
});
onEvent("screenL01", "click", function( ) {
  setScreen("screenTop200World");
});
onEvent("screenR02", "click", function( ) {
  setScreen("screenSaveList");
});
onEvent("screenL02", "click", function( ) {
  setScreen("screenTop200USA");
});

//Top 200 Songs Worldwide
//Making the left and right buttons work
onEvent("leftButton01", "click", function( ) {
  if (trackName01Index > 0) {
    trackName01Index = trackName01Index - 1;
  } else {
    trackName01Index = 199;
  }
  if (artist01Index > 0) {
    artist01Index = artist01Index - 1;
  } else {
    artist01Index = 199;
  }
  if (position01Index > 0) {
    position01Index = position01Index - 1;
  } else {
    position01Index = 199;
  }
  updateScreenTop200();
});
onEvent("rightButton01", "click", function( ) {
  if (trackName01Index < trackName01.length - 1) {
    trackName01Index = trackName01Index + 1;
  } else {
    trackName01Index = 0;
  }
  if (artist01Index < artist01.length - 1) {
    artist01Index = artist01Index + 1;
  } else {
    artist01Index = 0;
  }
  if (position01Index < position01.length - 1) {
    position01Index = position01Index + 1;
  } else {
    position01Index = 0;
  }
  updateScreenTop200();
});
onEvent("firstSongButton", "click", function( ) {
  setText("positionList01", "# " + 1);
  setText("trackList01", trackName01[0]);
  setText("artistList01", artist01[0]);
});
onEvent("lastSongButton", "click", function( ) {
  setText("positionList01", "# " + 200);
  setText("trackList01", trackName01[199]);
  setText("artistList01", artist01[199]);
});

//Top 200 Songs USA
//Randomize Button
