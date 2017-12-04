function onEdit(e){
  rewriteSpreadSheet()
}

function rewriteSpreadSheet() {
  var name = "AndroidFilter";
  var fileID = "16mohp33sM4PwnS0sJ6Rk1sgdoR7H2AXWjPzgKgP0iwo"

  var originSheet = SpreadsheetApp.openById(fileID);
  originSheet.getActiveSheet().clear();

  // clone targetSheet
  var targetSheet = SpreadsheetApp.openById("1RL9ImoykUuejWd7fc-MaAbDN8YFhDWB2W7asXNCof8Y");
  var sheet = targetSheet.getSheets()[0]
  var data = sheet.getDataRange().getValues();
  for (var i = 0; i < data.length; i++) {
    originSheet.appendRow(data[i]);
  }

  // Change sheet name
  originSheet.getSheets()[0].setName(sheet.getName())
}