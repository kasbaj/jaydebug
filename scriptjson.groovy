import groovy.json.*
import groovy.json.JsonSlurper


        println 'hello world'

       // String fileContents = new File('C:\\test\\sample.json').getText('UTF-8')
       String fileContents = new File('C:\\test\\testdataTemplate.json').getText('UTF-8')

 /* String jsonString = '''{"menu": {
"id": "file",
"tools": {
"actions": [
{"id": "new", "title": "New File"},
{"id": "open", "title": "Open File"},
{"id": "close", "title": "Close File"}
],
"errors": []
}}}'''
 */
JsonSlurper slurper = new JsonSlurper()
def parsedJson = slurper.parseText(fileContents)

String d = new JsonBuilder(parsedJson).toPrettyString()
println "pringi ${d}"

def jobName = parsedJson."Create_Site"
def jobName1 = "Create_Site"

println parsedJson.buildnumber
println parsedJson.jobs."$jobName1"
def iterations = parsedJson.jobs."$jobName1".size
println "sieze is ${iterations}"

data = getJobData(d,jobName1,0)
println "data is --> ${data}"


println "priting in loop"
for (int i=0;i<iterations;i++ )
{
    println parsedJson.jobs."$jobName1"[i]
}


def getJobData(String jsonData,String jobName,int cntr)
{
    JsonSlurper jslurper = new JsonSlurper()
    def val =  jslurper.parseText(jsonData).jobs."$jobName"[cntr]
    println "valud of ${val}"

    

    return val 
}






