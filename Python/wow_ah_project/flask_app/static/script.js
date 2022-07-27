function search(e){
    e.preventDefault();
    var searchForm = document.getElementById('ah_query')
    var form = new FormData(searchForm);
    fetch('http://localhost:5000/search',{method:'POST',body:form})
        .then(res => res.json() )
        .then( data => console.log(data) )
}