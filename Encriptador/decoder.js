const copyBtn = document.querySelector("#copyBtn");
const cleanBtn = document.querySelector("#cleanBtn");
const ioTextArea = document.getElementById("ioTextArea");
//copyBtn.style.display = "none";
//cleanBtn.style.display = "none";



function encode(){
    const message = ioTextArea.value;
    var encodedMessage = "";
    let character;
    
    for(var i = 0; i < message.length; i++){
        character = message.substring(i,i+1);
        switch(character){
            case 'a':
                character = "ai"; //a
            break; 
            case 'i':
                character = "imes"; //i
            break; 
            case 'u':
                character = "ufat"; //u
            break;                  
            case 'e':
                character = "enter"; //e
            break;
            case 'o':
                character = "ober"; //o
            break;
            
        }
        encodedMessage = encodedMessage.concat(character);
    }
    console.log(encodedMessage);
    ioTextArea.style.color = "rgb(241, 139, 165)";
    ioTextArea.value = encodedMessage;
}


function decode(){
    const message = ioTextArea.value;
    const array=[];
    var character='';
    var decodedMessage='';

    for(var i=0; i<message.length; i++){
        array.push(message.substring(i,i+1));
    }

    for(var i=0; i<message.length; i++){
        character = array[i];

        switch (character) {
            case 'a':  
                if(array[i+1]=='i'){
                    array.splice(i+1,1);
                }
            break;
            case 'i':
                if(array[i+1]=='m' && array[i+2]=='e' && array[i+3]=='s'){
                    array.splice(i+1,3);
                }
            break;
            case 'u':
                if(array[i+1]=='f' && array[i+2]=='a' && array[i+3]=='t'){
                    array.splice(i+1,3);
                }
            break;
            case 'e':
                if(array[i+1]=='n' && array[i+2]=='t' && array[i+3]=='e' && array[i+4]=='r'){
                    array.splice(i+1,4);
                }
            break;
            case 'o':
                if(array[i+1]=='b' && array[i+2]=='e' && array[i+3]=='r'){
                    array.splice(i+1,3);
                }
            break;
        }
    }

    for(var i=0; i<array.length; i++){
        decodedMessage = decodedMessage.concat(array[i]);
    }
    console.log(decodedMessage);
    ioTextArea.style.color = "rgb(193, 182, 240)";
    ioTextArea.value = decodedMessage;
}

function copyToClipboard(){
    
    navigator.clipboard.writeText(ioTextArea.value).then(
    () => {
        console.log("Text has been copied to clipboard")
        if(ioTextArea.value!=""){
            ioTextArea.select();
        }   
    },
    () => {
        console.log("Couldn't copy text");
    },
    ); 
    ioTextArea.style.color = "white";
}

function cleanTextArea(){
    ioTextArea.value = "";
    ioTextArea.style.color = "white";
}

