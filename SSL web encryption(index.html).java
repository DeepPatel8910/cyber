//Create new java web application(ssh)

//Index.html
<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
<body>
<form>
<div class="container">
<label>Username : </label>
<input type="text" placeholder="Enter Username" name="username" required>
<br><br>
<label>Password : </label>
<input type="password" placeholder="Enter Password" name="password" required>
<button type="submit">Login</button>
</div>
</form>
</body>
</html>


//Create new class in defaultpackage (ClassServer.java)
import java.io.*;
import java.net.*;
import javax.net.*;
public abstract class ClassServer implements Runnable {
private ServerSocket server = null;
protected ClassServer(ServerSocket ss)
{
server = ss;
newListener();
}
public abstract byte[] getBytes(String path)
throws IOException, FileNotFoundException;
public void run()
{
Socket socket;
try {
socket = server.accept();
} catch (IOException e) {
System.out.println("Class Server died: " + e.getMessage());
e.printStackTrace();
return;
}
newListener();
try {
OutputStream rawOut = socket.getOutputStream();
PrintWriter out = new PrintWriter(
new BufferedWriter(
new OutputStreamWriter(
rawOut)));
try {
// get path to class file from header
BufferedReader in =
new BufferedReader(
new InputStreamReader(socket.getInputStream()));
String path = getPath(in);
byte[] bytecodes = getBytes(path);
try {
out.print("HTTP/1.0 200 OK\r\n");
out.print("Content-Length: " + bytecodes.length +
"\r\n");
out.print("Content-Type: text/html\r\n\r\n");
out.flush();
rawOut.write(bytecodes);
rawOut.flush();
} catch (IOException ie) {
ie.printStackTrace();
return;
}
} catch (Exception e) {
e.printStackTrace();
// write out error response
out.println("HTTP/1.0 400 " + e.getMessage() + "\r\n");
out.println("Content-Type: text/html\r\n\r\n");
out.flush();
}
} catch (IOException ex) {
System.out.println("error writing response: " + ex.getMessage());
ex.printStackTrace();
} finally {
try {
socket.close();
} catch (IOException e) {
}
}
}
private void newListener()
{
(new Thread(this)).start();
}
private static String getPath(BufferedReader in)
throws IOException
{
String line = in.readLine();
String path = "";
// extract class from GET line
if (line.startsWith("GET /")) {
line = line.substring(5, line.length()-1).trim();
int index = line.indexOf(' ');
if (index != -1) {
path = line.substring(0, index);
}
}
// eat the rest of header
do {
line = in.readLine();
} while ((line.length() != 0) &&
(line.charAt(0) != '\r') && (line.charAt(0) != '\n'));
if (path.length() != 0) {
return path;
} else {
throw new IOException("Malformed Header");
}
}
}

