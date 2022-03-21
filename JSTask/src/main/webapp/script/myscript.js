
function trapFinder(start,end,b)
{
	const map=new Map();
	for(start;start<end+1;start++)
	{	
	var sum=start;
	while(sum>0)
	{
	if(start%b==0 || b%start==0 || sum%b==0 || b%sum==0)
	{
        map.set(start,b);
		b+=2;
	}
	else
	{
		if(b!=3)
		{
			b--;
		}
	}
	 if(sum<10)
	 {
		break;
	 }
	sum=findSum(sum);
	}
	}
	return map;
}


function findSum(number)  
{
 var sum = 0;
         
        while (number != 0)
        {
            sum = sum + number % 10;
            number = Math.floor(number/10);
        }
    return Math.floor(sum);
}

function toBinary(input)
{
  var a=input;
  var out="";
  while(a>0)
  {
    out = (a%2)+out;
    a=Math.floor(a/2);  
  }
  return out;
}


function parentChild()
{
const parents=document.getElementsByName("parent");
const childs=document.getElementsByName("child");
const map=new Map();
let list=new Array();

for(var a=0;a<parents.length;a++)
{
	if(map.get(parents[a].value)==null)
	{
		list=new Array();
    	
		map.set(parents[a].value,list);
	}
	map.get(parents[a].value).push(childs[a].value);
}
return map;
}

function getChild()
{
	let	search=document.getElementById("search").value;
	let map=parentChild();
    let arr=map.get(search);
    var length=0;
    let outArray=new Array();
	for(var a=0;a<arr.length;a++)
	{
	var out=map.get(arr[a]);
	if(out!=null)
	{
	length=length+out.length;
	outArray.push(out);
	}
	}
if(length>1)
{
	document.getElementById("message").innerText+=search+" has "+length+" grandchildrens" +". They are "+outArray+".";
}
else if(length===1)
{
	document.getElementById("message").innerText+=search+" has "+length+" grandchild "+"whose name is "+outArray+".";
}	
else if(length===0)
{
	document.getElementById("message").innerText+=search+" has no grandchildrens";
}	
}

let out="";
var exp;
function calci(number)
{
	//addition
	if(number=='+')
	{	
	document.getElementById('*').style.backgroundColor="black";
	document.getElementById('/').style.backgroundColor="black";
	document.getElementById('-').style.backgroundColor="black";
	out+=document.getElementById("displayer").value;
	document.getElementById(number).style.backgroundColor="red";
	exp=out;
	if(exp.charAt(exp.length-1)=="-")
	{
		document.getElementById(number).style.backgroundColor="red";
		out=exp.substring(0,exp.length-2)
	}
	else if(exp.charAt(exp.length-2)=="*" || exp.charAt(exp.length-2)=="/" || exp.charAt(exp.length-2)=="+" || exp.charAt(exp.length-2)=="-" && exp.charAt(exp.length-1)==" ")
	{
	out=exp.substring(0, exp.length-3);
	console.log(out);
	out+=" + ";
	document.getElementById("displayer1").value=out;
	}
	else
	{
	out+=" + ";
	document.getElementById("displayer1").value=out;
	document.getElementById("displayer").value="";
	}
	}
	//subtraction
	else if(number=='-')
	{
	document.getElementById("displayer1").value=out;
	document.getElementById('*').style.backgroundColor="black";
	document.getElementById('/').style.backgroundColor="black";
	document.getElementById('+').style.backgroundColor="black";
	out+=document.getElementById("displayer").value;
	exp=out;
	if(exp.charAt(exp.length-1)=="-")
	{
		document.getElementById(number).style.backgroundColor="red";
		out=exp.substring(0,exp.length-2)
	}
	else if(exp.charAt(exp.length-2)=="*" ||exp.charAt(exp.length-2)=="/" ||exp.charAt(exp.length-2)=="+" ||exp.charAt(exp.length-2)=="-" && exp.charAt(exp.length-1)==" "){
	document.getElementById(number).style.backgroundColor="red";
    out+=document.getElementById("displayer").value;
	document.getElementById("displayer").value=" -";
	document.getElementById("displayer1").value=out;
	}
	else{
	document.getElementById(number).style.backgroundColor="red";
    out+=" - ";
    document.getElementById("displayer1").value=out;
    document.getElementById("displayer").value="";
	}
	}
	
	//multiplication
	else if(number=='*')
	{
	document.getElementById("displayer1").value=out;
	document.getElementById('+').style.backgroundColor="black";
	document.getElementById('/').style.backgroundColor="black";
	document.getElementById('-').style.backgroundColor="black";
	out+=document.getElementById("displayer").value;
	exp=out;
	if(exp.charAt(exp.length-1)=="-")
	{
		document.getElementById(number).style.backgroundColor="red";
		out=exp.substring(0,exp.length-2)
	}
	else if(exp.charAt(exp.length-2)=="*" || exp.charAt(exp.length-2)=="-" && exp.charAt(exp.length-1)==" " ||exp.charAt(exp.length-2)=="/" ||exp.charAt(exp.length-2)=="+"){
    out=exp.substring(0, exp.length-3);
	document.getElementById(number).style.backgroundColor="red";
	out+=" * ";
	document.getElementById("displayer1").value=out;
	document.getElementById("displayer").value="";
	}
	else
	{
	document.getElementById(number).style.backgroundColor="red";
	out+=" * ";
	document.getElementById("displayer1").value=out;
	document.getElementById("displayer").value="";
	}
	}
	//division
	else if(number=='/')
	{
	document.getElementById('*').style.backgroundColor="black";
	document.getElementById('+').style.backgroundColor="black";
	document.getElementById('-').style.backgroundColor="black";
	out+=document.getElementById("displayer").value;
	exp=out;
	if(exp.charAt(exp.length-1)=="-")
	{
		document.getElementById(number).style.backgroundColor="red";
		out=exp.substring(0,exp.length-2)
	}
	else if(exp.charAt(exp.length-2)=="*" ||exp.charAt(exp.length-2)=="-" && exp.charAt(exp.length-1)==" " ||exp.charAt(exp.length-2)=="+" || exp.charAt(exp.length-2)=="/"){
	out=exp.substring(0, exp.length-3);
	document.getElementById(number).style.backgroundColor="red";
	out+=" / ";
	document.getElementById("displayer1").value=out;
	document.getElementById("displayer").value="";
	}
	else
	{
	document.getElementById(number).style.backgroundColor="red";
	out+=" / "	;
	document.getElementById("displayer1").value=out;
	document.getElementById("displayer").value="";
	}
	}
	
	else if(number==ce)
	{  
	exp = document.getElementById("displayer").value;  
	document.getElementById("displayer").value= exp.substring(0, exp.length - 1);   
	}
	 
	else if(number==ac)
	{
	document.getElementById("hidden").value="";  
	document.getElementById("displayer").value= "0"; 
	document.getElementById("displayer1").value="";  
	} 
	
	else if(number==radic)
	{  
	document.getElementById("hidden").value=document.getElementById("hidden").value+document.getElementById("displayer").value;
	document.getElementById("displayer").value="";
	}
	
	else
	{
	document.getElementById("displayer").value+=number;
	var num="";
	var dis= document.getElementById("displayer").value;
	dis=dis.replaceAll(",","");
	console.log("This comma replaced "+dis);
	num=numberFormat(dis);
	console.log(num);
    document.getElementById("displayer").value=num;
	document.getElementById("displayer1").value+=number;
	}
}

function equals()
{
	document.getElementById('+').style.backgroundColor="black";
	document.getElementById('*').style.backgroundColor="black";
	document.getElementById('/').style.backgroundColor="black";
	document.getElementById('-').style.backgroundColor="black";
  	var output=0;
	out+=document.getElementById("displayer").value;
	document.getElementById("displayer1").value=out;
	console.log("This is output string "+out);
	output=calculate(out);
	out="";
	document.getElementById("displayer").value=numberFormat(output);
}

function calculate(str){	
	
	str=str.replaceAll(",","");
	console.log("This is comma replaced string " +str);
	let arr = str.split(" ");
	arr =  arr.filter(e =>  e);
    for(var a=0;a<arr.length;a+=2)
	{
        switch (arr[a+1]) {
            case '+':
                arr[a+2] = (+arr[a] + +arr[a+2]);
                break;
            case '-':
                arr[a+2] = (+arr[a] - +arr[a+2]);
               break;
            case '/':
                arr[a+2] = (+arr[a] / +arr[a+2]);
               break;
            case '*':
                arr[a+2] = (+arr[a] * +arr[a+2]);
                break;
            default:
   			{
			if(arr[a+1]<0)
			{
 			arr[a+1] = (+arr[a] + +arr[a+1]);	
			}
            break;	
			}
        };
   	 if(a==arr.length-1)
	 {
		return arr[a];
	 }
	}
}

function numberFormat(input){
	
 	var str = input.toString().split(".");
	var length=str[0].length;
 	var ch=str[0].charAt(length-1);
	str[0]=str[0].substring(0, str[0].length-1);
    str[0] = str[0].replace(/\B(?=(\d{2})+(?!\d))/g, ",");
	str[0]=str[0]+ch;
    return str.join(".");
	
}

