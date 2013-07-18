ant-bigtext
===========

write ascii art text using an ant task

Example output
==============

  [bigtext]                          ****  ****
  [bigtext]    *###*   *###*          **    **
  [bigtext]     ***     ***           **    **
  [bigtext]     **      **            **    **
  [bigtext]     **      **           **    **
  [bigtext]    **      **    *****   **    **     ******
  [bigtext]    **      **  *******   **    **   ********
  [bigtext]    *#######**  **   **  **    **    **    **
  [bigtext]   **      **  **   ***  **    **   **     **
  [bigtext]   **      **  *******   **    **   **     **
  [bigtext]   **      **  *****    ***   ***   **     **
  [bigtext]  **      **   *     ** ****  ****  *     **
  [bigtext] ****    ****  *** **** ****  ****  **  ****
  [bigtext] ###*   *###*  ******   ***   ***   ******

Example ant build file
======================

<project default="test">
    <target name="test">
        <taskdef name="bigtext" classname="BigText" classpath="../jar/bigtext.jar" />
        <bigtext message="Hello" />
    </target>
</project>

Firstly, add the bigtext task to the build file, using 'taskdef'.

Then, you can freely create 'bigtext' tasks.  You put the message into the 'message' attribute.  The following attributes are available:

message: the message to print, mandatoary
size: how big to print the message, optional, default: 20
fontname: the font to use, optional, default: Times New Roman

Build instructions
==================

Pre-requisities
---------------

 * have ant installed, and in the PATH
 * have a jdk installed, and in the PATH

Procedure
---------

 * from the ant-bigtext directory, type 'ant'
 
 To see a test example:
 
 * from the ant-bigtext directory, type 'ant test'
 
License
=======

Mozilla Public License 2.0
