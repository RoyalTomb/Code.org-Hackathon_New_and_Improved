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
onEvent("randomButton01", "click", function( ) {
  updateRandomizer();
});

//Save List Screen
//"Add!" Button
var additiveList = [];
var allSongs = 0;
orderList();
function orderList() {
  if (allSongs == 0) {
    setProperty("removeButton", "hidden", true);
  } else {
    setProperty("removeButton", "hidden", false);
  }
  setProperty("addList", "text", ("Total Songs: " + allSongs) + "\n" + additiveList.join("\n"));
}
onEvent("addButton", "click", function( ) {
  var newItem = getText("addSongs");
  allSongs = allSongs + 1;
  insertItem(additiveList, 0, newItem);
  setText("addSongs", "");
  orderList();
});
//"Remove Item" Button
onEvent("removeButton", "click", function( ) {
  removeItem(additiveList, 0);
  allSongs = allSongs - 1;
  orderList();
});
//Traversing the Viral 50 Worldwide
onEvent("viral50L", "click", function( ) {
  if (trackName03Index > 0) {
    trackName03Index = trackName03Index - 1;
  } else {
    trackName03Index = 49;
  }
  if (artist03Index > 0) {
    artist03Index = artist03Index - 1;
  } else {
    artist03Index = 49;
  }
  if (position03Index > 0) {
    position03Index = position03Index - 1;
  } else {
    position03Index = 49;
  }
  update50ww();
});
onEvent("viral50R", "click", function( ) {
  if (trackName03Index < trackName03.length - 1) {
    trackName03Index = trackName03Index + 1;
  } else {
    trackName03Index = 0;
  }
  if (artist03Index < artist03.length - 1) {
    artist03Index = artist03Index + 1;
  } else {
    artist03Index = 0;
  }
  if (position03Index < position03.length - 1) {
    position03Index = position03Index + 1;
  } else {
    position03Index = 0;
  }
  update50ww();
});

//Functions
function updateScreenTop200() {
  var trackName01List = trackName01[trackName01Index];
  var artist01List = artist01[artist01Index];
  var position01List = position01[position01Index];
  setText("positionList01", "# " + position01List);
  setText("trackList01", trackName01List);
  setText("artistList01", artist01List);
}

function updateRandomizer() {
  var randomUpdate = randomNumber(0, trackName02.length - 1);
  setText("trackList02", trackName02 [randomUpdate]);
  setText("positionList02", position02 [randomUpdate]);
  setText("artistList02", artist02 [randomUpdate]);
}

function update50ww() {
  var trackName03List = trackName03 [trackName03Index];
  var artist03List = artist03 [artist03Index];
  var position03List = position03 [position03Index];
  setText("viral50S", trackName03List);
  setText("viral50A", artist03List);
  setText("viral50N", "# " + position03List);
}
