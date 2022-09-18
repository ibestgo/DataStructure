/*
 *  CONFIDENTIAL -- Copyright 2022 Karius, Inc
 *
 *  This material contains certain confidential and proprietary information.
 *  Use, reproduction, disclosure and distribution by any means are prohibited,
 *  except pursuant to a written license from Karius, Inc (help@kariusdx.com)
 *  Use of copyright notice is precautionary and does not imply publication
 *  or disclosure.
 *
 *  @author Baechul Kim
 */

class CSV {

  /**
   * A static method to parse the CSV content string to a JSON object.
   * It takes a CSV file content as a string (each line should be delimited by a new line) and parses in to an array
   * whose element is a hash object. Each object key is a column name and value is the column data.
   *
   * If a non-string param is passed, an error will be thrown. If an empty string param is passed or the param contains
   * only header line, an empty array will be returned.
   *
   * @param csvContent
   */
  static parse(csvContent) {
    if(typeof csvContent !== 'string') {
      throw new Error(`Invalid csvContent passed: ${csvContent}`)
    }

    const retArray = []
    if(csvContent.trim() === '') return retArray

    const lines = csvContent.split('\n')
    const headerLine = lines[0]
    let colNames = CSV._splitByCommaForCSV(headerLine) // headerLine.split(',') was a naive approach!
    colNames = colNames.map(colName => {
      // if the colName is quoted, strip them
      return colName.replace(/^["']|["']$/g, '')
    })

    // data part
    for(let i=1; i < lines.length; i++) {
      const curLine = lines[i]
      const curData =CSV._splitByCommaForCSV(curLine)  // curLine.split(',')
      if(curData.length !== colNames.length) {
        console.error(JSON.stringify(curData, null, 2))
        throw new Error(`The number of data and header columns are different: ${curData.length}, ${colNames.length}`)
      }

      const lineObj = {}
      colNames.forEach((colName, idx) => {
        lineObj[colName] = curData[idx]
      })
      retArray.push(lineObj)
    }

    return retArray
  }

  // a private method to handle a case with a comma within the double quotes. maybe consider a single as well??
  static _splitByCommaForCSV(line) {
    if(typeof line !== 'string' || line === '') {
      throw new Error('Invalid param passed: '+line)
    }
    const ret = []
    let valueLetters = []

    for(let c of line) {
      if(c === ',' && !valueLetters.includes('"')) {
        ret.push(valueLetters.join(''))
        valueLetters = []
      } else if(c === '"') {
        if(valueLetters.length > 0 && valueLetters.includes('"')) {  // c must be the ending quote.
          valueLetters.shift()  // remove the beginning quote and skip the current c (which is ")
          valueLetters = valueLetters.filter(one => one !== '"')
        } else {
          valueLetters.push(c)
        }
      } else {
        valueLetters.push(c)
      }
    }

    // handle the last one
    if(valueLetters[valueLetters.length -1] === '\r') { // remove the line break first.
      valueLetters.pop()
    }

    ret.push(valueLetters.join(''))
    return ret
  }

  function _splitByCommaForCSV_BETTER(line) {
    if (typeof line !== 'string') {
      throw new Error(`Invalid param passed: ${line}`)
    }
    // Remove trailing linebreaks
    line = line.replace(/(\n|\r)*$/, '')
    const ret = []
    let column = ""
    // Are we inside the quotations for a column?
    let insideQuote = false
    // Are we currently consuming characters for a column value?
    let parsingCol = true

    for(let c of line) {
      if (c === ',' && !insideQuote) {
        ret.push(column)
        column = ""
        parsingCol = true
      } else if (c === '"' && !insideQuote) {
        // Open quote
        // Remove whitespace before the quote
        column = column.replace(/\s/g, "")
        if (column.length > 0) {
          throw new Error(`Invalid CSV row: ${line}`)
        }
        insideQuote = true
      } else if (c === '"' && insideQuote) {
        // Close quote
        insideQuote = false
        parsingCol = false
      } else if (parsingCol) {
        column += c
      } else if (c !== " ") {
        // Extra characters after close quote
        throw new Error(`Invalid CSV row: ${line}`)
      }
    }
    ret.push(column)
    return ret
  }
}

export default CSV

