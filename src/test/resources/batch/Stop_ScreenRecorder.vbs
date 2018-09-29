Dim oShell
Set oShell = CreateObject("WScript.Shell")
oShell.AppActivate "Launch Screen Recorder Application"
WScript.Sleep 500
oShell.SendKeys "q"
oShell.SendKeys "exit"
oShell.SendKeys "{Enter}"
Set oShell = nothing