package com.ys.test.androidtestsamples.io

import java.io.*

/**
 * Created by Albert-IM on 27/11/2017.
 */
class FileManager {

    fun writeToFile(file: File, fileContent: String) {
        if(!file.exists()) {
            try {
                val fileWriter = FileWriter(file)
                fileWriter.write(fileContent)
                fileWriter.close()
            } catch (e: IOException) {
                e.printStackTrace()
            }
        }
    }

    fun readFileContent(file: File): String {
        val fileContentBuilder = StringBuilder()

        if(file.exists()) {
            try {
                val fileReader = FileReader(file)
                val bufferedReader = BufferedReader(fileReader)


                for (line in fileReader.readLines()) {
                    fileContentBuilder.append(line).append("\n")
                }

                bufferedReader.close()
                fileReader.close()

            } catch (e: IOException) {
                e.printStackTrace()
            }
        }

        return fileContentBuilder.toString()
    }
}