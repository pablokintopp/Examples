var headers = [ "TIPREG", "DT_PREG", "CODBDI", "CODNEG",
 "TPMERC", "NOMRES", "ESPECI", "PRAZOT", "MODREF", "PREABE", 
 "PREMAX", "PREMIN", "PREMED", "PREULT", "PREOFC", "PREOFV",
  "TOTNEG", "QUATOT", "VOLTOT", "PREEXE" ,"INDOPC",
  "DATVEN", "FATCOT", "PTOEXE", "CODISI", "DISMES", ];
var initPos = [0,2,10,12,24,27,39,49,52,56,69,82, 95,108,121,134,147,152,170,188,201,202,210,217,230,242];
var endtPos = [1,9,11,23,26,38,48,51,55,68,81,94,107,120,133,146,151,169,187,200,201,209,216,229,241,244];

function handleFiles() {
    // Check for the various File API support.
    if (window.FileReader) {
        // FileReader are supported.     
        var files = $('#files').prop('files');
        console.log('Files length: '+ files.length);
        var rowContent = createRowContent(headers, true);
        $('#table-stocks thead').append(rowContent);
        for (let index = 0; index < files.length; index++) {
            getAsText(files[index]);            
        }
        
    } else {
        alert('FileReader are not supported in this browser.');
    }
  }

  function getAsText(fileToRead) {
    var reader = new FileReader();
    // Read file into memory as UTF-8      
    reader.readAsText(fileToRead);
    // Handle errors load
    reader.onload = loadHandler;
    reader.onerror = errorHandler;
  }

  function loadHandler(event) {
    var txt = event.target.result;
    processData(txt);
  }

  function processData(txt) {
      var allTextLines = txt.split(/\r\n|\n/);
      var totalLines = 100; //allTextLines.length;
      for (var i=1; i<totalLines; i++) {
           var data = customSplit(allTextLines[i]);
            var rowContent = createRowContent(data);              
             $('#table-stocks tbody').append(rowContent);
              
             
      }
    // console.log(lines);
  }

  function errorHandler(evt) {
    if(evt.target.error.name == "NotReadableError") {
        alert("Canno't read file !");
    }
  }

  

  function customSplit(line){
      var cols = [];
      for (let i = 0; i < initPos.length; i++) {
        var col = line.slice(initPos[i],endtPos[i] + 1)
        cols.push(col);
      }

      return cols;
      


  }

  function createRowContent(data, isHeader = false) {
      var rowData = "<tr>";

      for (let index = 0; index < data.length; index++) {
         rowData+= !isHeader ?  "<td>" : "<th>";

         rowData+= data[index];

         rowData+= !isHeader ?  "</td>" : "</th>";
      }

      rowData+= "</tr>";

      return rowData;


  }