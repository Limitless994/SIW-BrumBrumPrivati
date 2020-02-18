
function Xcategoria(){
	var Utilitaria=  $('.active input[value="2"]').attr('name');
	var Sportiva=  $('.active input[value="3"]').attr('name');
	var CityCar=  $('.active input[value="4"]').attr('name');

	var categorie;
	categorie=document.getElementsByClassName("cat");  //cat sono le categorie 
	
	if(Utilitaria==null && Sportiva==null && CityCar==null ) 
		window.location.reload();

	for(var i = 0; i < categorie.length; i++)
	{

		var pippo=document.getElementsByClassName(categorie[i].innerHTML);
		for(var j=0; j<pippo.length; j++){
			pippo[j].style.display = 'none';  }
	}
	for(var i = 0; i < categorie.length; i++)
	{
		if(Utilitaria!=null)
		{
			if(categorie[i].innerHTML.includes(Utilitaria)) // qui controllo se l'auto appartiene a quella categoria
			{
				var pippo=document.getElementsByClassName(categorie[i].innerHTML);
				for(var j=0; j<pippo.length; j++){
					pippo[j].style.display = 'block';  }
			}
		}
		if(Sportiva!=null)
		{

			if(categorie[i].innerHTML.includes(Sportiva)) // qui controllo se l'auto appartiene a quella categoria
			{

				var pippo=document.getElementsByClassName(categorie[i].innerHTML);
				for(var j=0; j<pippo.length; j++){   
					pippo[j].style.display = 'block';  }
			}
		}
		if(CityCar!=null)
		{
			if(categorie[i].innerHTML.includes(CityCar)) // qui controllo se l'auto appartiene a quella categoria
			{

				var pippo=document.getElementsByClassName(categorie[i].innerHTML);
				for(var j=0; j<pippo.length; j++){   
					pippo[j].style.display = 'block';  }
			}
		}
	}
}

function reset(k){
	for(var i = 0; i < k.length; i++)
	{
		var pippo=document.getElementsByClassName(k[i].innerHTML);
		for(var j=0; j<pippo.length; j++){
			pippo[j].style.display = 'none';  
		}
	}
}



function Xalimentazione(){

	var Benzina=  $('.active input[value="5"]').attr('name');
	var Diesel=  $('.active input[value="6"]').attr('name');
	
	console.log(Benzina);
	
	
	var alimentazione=null;
	alimentazione=document.getElementsByClassName("alim");  

	for(var i = 0; i < alimentazione.length; i++)
	{
		var pippo=document.getElementsByClassName(alimentazione[i].innerHTML);
		for(var j=0; j<pippo.length; j++){
			pippo[j].style.display = 'none';  
		}
	}


	for(var i = 0; i < alimentazione.length; i++)
	{
		if(Benzina!=null)
		{

			if(alimentazione[i].innerHTML.includes(Benzina)) // qui controllo se l'auto appartiene a quella categoria
			{

				var pippo=document.getElementsByClassName(alimentazione[i].innerHTML);
				for(var j=0; j<pippo.length; j++){
					pippo[j].style.display = 'block';  }
			}

		}
		if(Diesel!=null)
		{

			if(alimentazione[i].innerHTML.includes(Diesel)) // qui controllo se l'auto appartiene a quella categoria
			{

				var pippo=document.getElementsByClassName(alimentazione[i].innerHTML);
				for(var j=0; j<pippo.length; j++){
					pippo[j].style.display = 'block';  }
			}

		}
	}


}




function Xcambio(){

	var Automatico=  $('.active input[value="7"]').attr('name');
	var Manuale=  $('.active input[value="8"]').attr('name');

	var cambio;
	cambio=document.getElementsByClassName("camb");  

	for(var i = 0; i < cambio.length; i++)
	{

		var pippo=document.getElementsByClassName(cambio[i].innerHTML);
		for(var j=0; j<pippo.length; j++){
			pippo[j].style.display = 'none';  }
	}


	for(var i = 0; i < cambio.length; i++)
	{

		if(Manuale!=null)
		{

			if(cambio[i].innerHTML.includes(Manuale)) // qui controllo se l'auto appartiene a quella categoria
			{

				var pippo=document.getElementsByClassName(cambio[i].innerHTML);
				for(var j=0; j<pippo.length; j++){
					pippo[j].style.display = 'block';  }
			}

		}

		if(Automatico!=null)
		{

			if(cambio[i].innerHTML.includes(Automatico)) // qui controllo se l'auto appartiene a quella categoria
			{

				var pippo=document.getElementsByClassName(cambio[i].innerHTML);
				for(var j=0; j<pippo.length; j++){
					pippo[j].style.display = 'block';  }
			}

		}
	}
}


function Xmarca(){

	var Fiat=  $('.active input[value="9"]').attr('name');
	var Mercedes=  $('.active input[value="10"]').attr('name');
	var Nissan=  $('.active input[value="11"]').attr('name');
	var Volkswagen=  $('.active input[value="12"]').attr('name');
	var Renault=  $('.active input[value="13"]').attr('name');



	var marca;
	marca=document.getElementsByClassName("marc");  

	for(var i = 0; i < marca.length; i++)
	{

		var pippo=document.getElementsByClassName(marca[i].innerHTML);
		for(var j=0; j<pippo.length; j++){
			pippo[j].style.display = 'none';  }
	}



	for(var i = 0; i < marca.length; i++)
	{
		if(Volkswagen!=null)
		{

			if(marca[i].innerHTML.includes(Fiat)) // qui controllo se l'auto appartiene a quella categoria
			{

				var pippo=document.getElementsByClassName(marca[i].innerHTML);
				for(var j=0; j<pippo.length; j++){
					pippo[j].style.display = 'block';  }
			}

		}

		if(Fiat!=null)
		{

			if(marca[i].innerHTML.includes(Fiat)) // qui controllo se l'auto appartiene a quella categoria
			{

				var pippo=document.getElementsByClassName(marca[i].innerHTML);
				for(var j=0; j<pippo.length; j++){
					pippo[j].style.display = 'block';  }
			}

		}

		if(Ford!=null)
		{

			if(marca[i].innerHTML.includes(Ford)) // qui controllo se l'auto appartiene a quella categoria
			{

				var pippo=document.getElementsByClassName(marca[i].innerHTML);
				for(var j=0; j<pippo.length; j++){
					pippo[j].style.display = 'block';  }
			}

		}

		if(Mercedes!=null)
		{

			if(marca[i].innerHTML.includes(Mercedes)) // qui controllo se l'auto appartiene a quella categoria
			{

				var pippo=document.getElementsByClassName(marca[i].innerHTML);
				for(var j=0; j<pippo.length; j++){
					pippo[j].style.display = 'block';  }
			}

		}
		if(Renault!=null)
		{

			if(marca[i].innerHTML.includes(Renault)) // qui controllo se l'auto appartiene a quella categoria
			{

				var pippo=document.getElementsByClassName(marca[i].innerHTML);
				for(var j=0; j<pippo.length; j++){
					pippo[j].style.display = 'block';  }
			}

		}
	}

}



function Xmodello(){


	var Sls=  $('.active input[value="14"]').attr('name');
	var TRoc=  $('.active input[value="15"]').attr('name');
	var Cinquecento=  $('.active input[value="16"]').attr('name');
	var Capture=  $('.active input[value="17"]').attr('name');

	var modello;
	modello=document.getElementsByClassName("mod");  

	for(var i = 0; i < modello.length; i++)
	{

		var pippo=document.getElementsByClassName(modello[i].innerHTML);
		for(var j=0; j<pippo.length; j++){
			pippo[j].style.display = 'none';  }
	}



	for(var i = 0; i < modello.length; i++)
	{
		//do something to each div like


		if(Cinquecento!=null)
		{

			if(modello[i].innerHTML.includes(Cinquecento)) // qui controllo se l'auto appartiene a quella categoria
			{

				var pippo=document.getElementsByClassName(modello[i].innerHTML);
				for(var j=0; j<pippo.length; j++){
					pippo[j].style.display = 'block';  }
			}

		}

		if(Sls!=null)
		{

			if(modello[i].innerHTML.includes(Sls)) // qui controllo se l'auto appartiene a quella categoria
			{

				var pippo=document.getElementsByClassName(modello[i].innerHTML);
				for(var j=0; j<pippo.length; j++){
					pippo[j].style.display = 'block';  }
			}

		}
		if(TRoc!=null)
		{

			if(modello[i].innerHTML.includes(TRoc)) // qui controllo se l'auto appartiene a quella categoria
			{

				var pippo=document.getElementsByClassName(modello[i].innerHTML);
				for(var j=0; j<pippo.length; j++){
					pippo[j].style.display = 'block';  }
			}

		}
		if(Capture!=null)
		{

			if(modello[i].innerHTML.includes(Capture)) // qui controllo se l'auto appartiene a quella categoria
			{

				var pippo=document.getElementsByClassName(modello[i].innerHTML);
				for(var j=0; j<pippo.length; j++){
					pippo[j].style.display = 'block';  }
			}

		}



	}

}











/*function RestAutoPerCategoria(){

var Utilitaria=  $('.active input[value="2"]').attr('name');
var Sportiva=  $('.active input[value="3"]').attr('name');
var CityCar=  $('.active input[value="4"]').attr('name');

var Benzina=  $('.active input[value="5"]').attr('name');
var Diesel=  $('.active input[value="6"]').attr('name');

var Automatico=  $('.active input[value="7"]').attr('name');
var Manuale=  $('.active input[value="8"]').attr('name');

var Fiat=  $('.active input[value="9"]').attr('name');
var Marcedes=  $('.active input[value="10"]').attr('name');
var Ford=  $('.active input[value="11"]').attr('name');
var Volkswagen=  $('.active input[value="12"]').attr('name');


var ClasseA=  $('.active input[value="13"]').attr('name');
var Golf=  $('.active input[value="14"]').attr('name');
var Cinquecento=  $('.active input[value="15"]').attr('name');
var EcoSport=  $('.active input[value="16"]').attr('name');


var categorie;
categorie=document.getElementsByClassName("cat");  //cat sono le categorie 

var alimentazione;
alimentazione=document.getElementsByClassName("alim");  

var cambio;
cambio=document.getElementsByClassName("camb");

var marca;
marca=document.getElementsByClassName("marc");

var modello;
modello=document.getElementsByClassName("mod");


for(var i = 0; i < categorie.length; i++)
{
	if(Utilitaria!=null)
	{

		if(!categorie[i].innerHTML.includes(Utilitaria)) // qui controllo se l'auto appartiene a quella categoria
		{
			var pippo=document.getElementsByClassName(categorie[i].innerHTML);
			for(var j=0; j<pippo.length; j++){
				pippo[j].style.display = 'none';  }
		}

	}
	else
	{
		if(categorie[i].innerHTML.includes(Utilitaria)) // qui controllo se l'auto appartiene a quella categoria
		{

			var pippo=document.getElementsByClassName(categorie[i].innerHTML);
			for(var j=0; j<pippo.length; j++){
				pippo[j].style.display = 'inline';  }
		}
	}


	if(Sportiva!=null)
	{

		if(!categorie[i].innerHTML.includes(Sportiva)) // qui controllo se l'auto appartiene a quella categoria
		{

			var pippo=document.getElementsByClassName(categorie[i].innerHTML);
			for(var j=0; j<pippo.length; j++){   
				pippo[j].style.display = 'none';  }
		}

	}
	if(CityCar!=null)
	{


		if(!categorie[i].innerHTML.includes(CityCar)) // qui controllo se l'auto appartiene a quella categoria
		{

			var pippo=document.getElementsByClassName(categorie[i].innerHTML);
			for(var j=0; j<pippo.length; j++){   
				pippo[j].style.display = 'none';  }
		}

	}


	if(Cinquecento==null && ClasseA==null && Golf==null && EcoSport==null && CityCar==null && Sportiva==null && Utilitaria==null && Benzina==null && Diesel==null  && Manuale==null && Automatico==null && Volkswagen==null
			&& Fiat==null && Ford==null)
	{
		window.location.reload()
	}


}



for(var i = 0; i < alimentazione.length; i++)
{
	//do something to each div like


	if(Benzina!=null)
	{

		if(!alimentazione[i].innerHTML.includes(Benzina)) // qui controllo se l'auto appartiene a quella categoria
		{

			var pippo=document.getElementsByClassName(alimentazione[i].innerHTML);
			for(var j=0; j<pippo.length; j++){
				pippo[j].style.display = 'none';  }
		}

	}
	if(Diesel!=null)
	{

		if(!alimentazione[i].innerHTML.includes(Diesel)) // qui controllo se l'auto appartiene a quella categoria
		{

			var pippo=document.getElementsByClassName(alimentazione[i].innerHTML);
			for(var j=0; j<pippo.length; j++){
				pippo[j].style.display = 'none';  }
		}

	}
}


for(var i = 0; i < cambio.length; i++)
{
	//do something to each div like


	if(Manuale!=null)
	{

		if(!cambio[i].innerHTML.includes(Manuale)) // qui controllo se l'auto appartiene a quella categoria
		{

			var pippo=document.getElementsByClassName(cambio[i].innerHTML);
			for(var j=0; j<pippo.length; j++){
				pippo[j].style.display = 'none';  }
		}

	}

	if(Automatico!=null)
	{

		if(!cambio[i].innerHTML.includes(Automatico)) // qui controllo se l'auto appartiene a quella categoria
		{

			var pippo=document.getElementsByClassName(cambio[i].innerHTML);
			for(var j=0; j<pippo.length; j++){
				pippo[j].style.display = 'none';  }
		}

	}
}


for(var i = 0; i < marca.length; i++)
{
	//do something to each div like


	if(Volkswagen!=null)
	{

		if(!marca[i].innerHTML.includes(Volkswagen)) // qui controllo se l'auto appartiene a quella categoria
		{

			var pippo=document.getElementsByClassName(marca[i].innerHTML);
			for(var j=0; j<pippo.length; j++){
				pippo[j].style.display = 'none';  }
		}

	}

	if(Fiat!=null)
	{

		if(!marca[i].innerHTML.includes(Fiat)) // qui controllo se l'auto appartiene a quella categoria
		{

			var pippo=document.getElementsByClassName(marca[i].innerHTML);
			for(var j=0; j<pippo.length; j++){
				pippo[j].style.display = 'none';  }
		}

	}

	if(Ford!=null)
	{

		if(!marca[i].innerHTML.includes(Ford)) // qui controllo se l'auto appartiene a quella categoria
		{

			var pippo=document.getElementsByClassName(marca[i].innerHTML);
			for(var j=0; j<pippo.length; j++){
				pippo[j].style.display = 'none';  }
		}

	}

	if(Marcedes!=null)
	{

		if(!marca[i].innerHTML.includes(Marcedes)) // qui controllo se l'auto appartiene a quella categoria
		{

			var pippo=document.getElementsByClassName(marca[i].innerHTML);
			for(var j=0; j<pippo.length; j++){
				pippo[j].style.display = 'none';  }
		}

	}
}


for(var i = 0; i < modello.length; i++)
{
	//do something to each div like


	if(Cinquecento!=null)
	{

		if(!modello[i].innerHTML.includes(Cinquecento)) // qui controllo se l'auto appartiene a quella categoria
		{

			var pippo=document.getElementsByClassName(modello[i].innerHTML);
			for(var j=0; j<pippo.length; j++){
				pippo[j].style.display = 'none';  }
		}

	}

	if(ClasseA!=null)
	{

		if(!modello[i].innerHTML.includes(ClasseA)) // qui controllo se l'auto appartiene a quella categoria
		{

			var pippo=document.getElementsByClassName(modello[i].innerHTML);
			for(var j=0; j<pippo.length; j++){
				pippo[j].style.display = 'none';  }
		}

	}
	if(Golf!=null)
	{

		if(!modello[i].innerHTML.includes(Golf)) // qui controllo se l'auto appartiene a quella categoria
		{

			var pippo=document.getElementsByClassName(modello[i].innerHTML);
			for(var j=0; j<pippo.length; j++){
				pippo[j].style.display = 'none';  }
		}

	}
	if(EcoSport!=null)
	{

		if(!modello[i].innerHTML.includes(EcoSport)) // qui controllo se l'auto appartiene a quella categoria
		{

			var pippo=document.getElementsByClassName(modello[i].innerHTML);
			for(var j=0; j<pippo.length; j++){
				pippo[j].style.display = 'none';  }
		}

	}



}

}






function annulla()
{


var Utilitaria=  $('.active input[value="2"]').attr('name');
var Sportiva=  $('.active input[value="3"]').attr('name');
var CityCar=  $('.active input[value="4"]').attr('name');

var Benzina=  $('.active input[value="5"]').attr('name');
var Diesel=  $('.active input[value="6"]').attr('name');

var Automatico=  $('.active input[value="7"]').attr('name');
var Manuale=  $('.active input[value="8"]').attr('name');

var Fiat=  $('.active input[value="9"]').attr('name');
var Marcedes=  $('.active input[value="10"]').attr('name');
var Ford=  $('.active input[value="11"]').attr('name');
var Volkswagen=  $('.active input[value="12"]').attr('name');


var ClasseA=  $('.active input[value="13"]').attr('name');
var Golf=  $('.active input[value="14"]').attr('name');
var Cinquecento=  $('.active input[value="15"]').attr('name');
var EcoSport=  $('.active input[value="16"]').attr('name');


var categorie;
categorie=document.getElementsByClassName("cat");  //cat sono le categorie 

var alimentazione;
alimentazione=document.getElementsByClassName("alim");  

var cambio;
cambio=document.getElementsByClassName("camb");

var marca;
marca=document.getElementsByClassName("marc");

var modello;
modello=document.getElementsByClassName("mod");




for(var i = 0; i < x.length; i++){
	//do something to each div like




	// rende visibili quelle che hanno almeno una categoria
	if(Utilitaria!=null){
		if(x[i].innerHTML.includes(Utilitaria))
		{
			var pippo=document.getElementsByClassName(x[i].innerHTML);

			for(var j=0; j<pippo.length; j++)
				pippo[j].style.display = 'block';
		}
	}


	if(Sportiva!=null){
		if(x[i].innerHTML.includes(Sportiva))
		{
			var pippo=document.getElementsByClassName(x[i].innerHTML);

			for(var j=0; j<pippo.length; j++)
				pippo[j].style.display = 'block';
		}
	}


	if(CityCar!=null){
		if(x[i].innerHTML.includes(CityCar))
		{

			var pippo=document.getElementsByClassName(x[i].innerHTML);

			for(var j=0; j<pippo.length; j++)
				pippo[j].style.display = 'block';

		}
	}

}





for(var i = 0; i < alimentazione.length; i++)
{
	//do something to each div like


	if(Benzina!=null)
	{

		if(alimentazione[i].innerHTML.includes(Benzina)) // qui controllo se l'auto appartiene a quella categoria
		{

			var pippo=document.getElementsByClassName(alimentazione[i].innerHTML);
			for(var j=0; j<pippo.length; j++){
				pippo[j].style.display = 'block';  }
		}

	}
	if(Diesel!=null)
	{

		if(alimentazione[i].innerHTML.includes(Diesel)) // qui controllo se l'auto appartiene a quella categoria
		{

			var pippo=document.getElementsByClassName(alimentazione[i].innerHTML);
			for(var j=0; j<pippo.length; j++){
				pippo[j].style.display = 'block';  }
		}

	}
}


for(var i = 0; i < cambio.length; i++)
{
	//do something to each div like


	if(Manuale!=null)
	{

		if(cambio[i].innerHTML.includes(Manuale)) // qui controllo se l'auto appartiene a quella categoria
		{

			var pippo=document.getElementsByClassName(cambio[i].innerHTML);
			for(var j=0; j<pippo.length; j++){
				pippo[j].style.display = 'block';  }
		}

	}

	if(Automatico!=null)
	{

		if(cambio[i].innerHTML.includes(Automatico)) // qui controllo se l'auto appartiene a quella categoria
		{

			var pippo=document.getElementsByClassName(cambio[i].innerHTML);
			for(var j=0; j<pippo.length; j++){
				pippo[j].style.display = 'block';  }
		}

	}
}


for(var i = 0; i < marca.length; i++)
{
	//do something to each div like


	if(Volkswagen!=null)
	{

		if(marca[i].innerHTML.includes(Volkswagen)) // qui controllo se l'auto appartiene a quella categoria
		{

			var pippo=document.getElementsByClassName(marca[i].innerHTML);
			for(var j=0; j<pippo.length; j++){
				pippo[j].style.display = 'block';  }
		}

	}

	if(Fiat!=null)
	{

		if(marca[i].innerHTML.includes(Fiat)) // qui controllo se l'auto appartiene a quella categoria
		{

			var pippo=document.getElementsByClassName(marca[i].innerHTML);
			for(var j=0; j<pippo.length; j++){
				pippo[j].style.display = 'block';  }
		}

	}

	if(Ford!=null)
	{

		if(marca[i].innerHTML.includes(Ford)) // qui controllo se l'auto appartiene a quella categoria
		{

			var pippo=document.getElementsByClassName(marca[i].innerHTML);
			for(var j=0; j<pippo.length; j++){
				pippo[j].style.display = 'block';  }
		}

	}

	if(Marcedes!=null)
	{

		if(marca[i].innerHTML.includes(Marcedes)) // qui controllo se l'auto appartiene a quella categoria
		{

			var pippo=document.getElementsByClassName(marca[i].innerHTML);
			for(var j=0; j<pippo.length; j++){
				pippo[j].style.display = 'block';  }
		}

	}
}


for(var i = 0; i < modello.length; i++)
{
	//do something to each div like


	if(Cinquecento!=null)
	{

		if(modello[i].innerHTML.includes(Cinquecento)) // qui controllo se l'auto appartiene a quella categoria
		{

			var pippo=document.getElementsByClassName(modello[i].innerHTML);
			for(var j=0; j<pippo.length; j++){
				pippo[j].style.display = 'block';  }
		}

	}

	if(ClasseA!=null)
	{

		if(modello[i].innerHTML.includes(ClasseA)) // qui controllo se l'auto appartiene a quella categoria
		{

			var pippo=document.getElementsByClassName(modello[i].innerHTML);
			for(var j=0; j<pippo.length; j++){
				pippo[j].style.display = 'block';  }
		}

	}
	if(Golf!=null)
	{

		if(modello[i].innerHTML.includes(Golf)) // qui controllo se l'auto appartiene a quella categoria
		{

			var pippo=document.getElementsByClassName(modello[i].innerHTML);
			for(var j=0; j<pippo.length; j++){
				pippo[j].style.display = 'block';  }
		}

	}
	if(EcoSport!=null)
	{

		if(modello[i].innerHTML.includes(EcoSport)) // qui controllo se l'auto appartiene a quella categoria
		{

			var pippo=document.getElementsByClassName(modello[i].innerHTML);
			for(var j=0; j<pippo.length; j++){
				pippo[j].style.display = 'block';  }
		}

	}
}


}*/





/*for(var i = 0; i < tutte.length; i++)
{
	if( (Utilitaria!=null && categorie[i].innerHTML.includes(Utilitaria)) || 
		(Sportiva!=null && categorie[i].innerHTML.includes(Sportiva))	)
	{
		var pippo=document.getElementsByClassName(categorie[i].innerHTML);
		for(var j=0; j<pippo.length; j++){
			pippo[j].style.display = 'block';  }
	}
}*/



