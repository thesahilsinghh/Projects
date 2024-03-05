const start = document.getElementById("Start");
const stop = document.getElementById("Stop");
const reset = document.getElementById("Reset");

const runner = document.getElementById("display");

let timer = false;
let hour = 0;
let mSeconds = 0;
let seconds = 0;
let minutes = 0;
let timerID;

function displayTime() {
  let tempHour = hour < 10 ? "0" + hour : hour;
  let tempMin = minutes < 10 ? "0" + minutes : minutes;
  let tempS = seconds < 10 ? "0" + seconds : seconds;
  let tempMs = mSeconds < 10 ? "0" + mSeconds : mSeconds;
  runner.textContent = tempHour + ":" + tempMin + ":" + tempS + ":" + tempMs;
}
function pauseClock() {
  clearTimeout(timerID);
}

function runClock() {
  displayTime();
  mSeconds++;

  if(minutes===60){
    hour++;
    minutes=0;
    seconds=0;
    mSeconds=0;
  }
  if (seconds === 60) {
    minutes++;
    seconds = 0;
  }

  if (mSeconds === 100) {
    seconds++;
    mSeconds = 0;
  }
  timerID = setTimeout(runClock, 10);
}

start.addEventListener("click", function () {
  start.disabled = true;
  stop.disabled = false;

  runClock();
});

stop.addEventListener("click", function () {
  start.disabled = false;
  stop.disabled = true;
  pauseClock();
});

reset.addEventListener("click", function () {
  clearTimeout(timerID);
  hour=0;
  mSeconds = 0;
  minutes = 0;
  seconds = 0;
  start.disabled = false;
  stop.disabled = true;

  displayTime();
});
