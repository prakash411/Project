function json(){
	let user = {
		Pickup: document.getElementById('origin-input').value,
		Destination: document.getElementById('destination-input').value
	}
	localStorage.setItem('loc_json', JSON.stringify(user) );
	console.log(user);
}

function remove_json(){
	localStorage.removeItem('loc_json');
}

function load_json(){
	let x;
	if(window.localStorage.getItem('loc_json')){
		x = JSON.parse(window.localStorage.getItem('loc_json'));
		document.getElementById('origin-input').value=x.Pickup;
		document.getElementById('destination-input').value=x.Destination;

	}
}