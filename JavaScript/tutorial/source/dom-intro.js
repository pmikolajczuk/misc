(function(){

    function clickHandler(message) {
        console.log('hi ...' + message);
    }

    let myButton = document.getElementById('myButton');
    myButton.addEventListener('click', () => clickHandler('hi from IFFE' ));
})();