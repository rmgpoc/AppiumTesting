Dim oShell
Set oShell = CreateObject("WScript.Shell")
oShell.AppActivate "BlueStacks"
WScript.Sleep 500
oShell.SendKeys "{Enter}"
Set oShell = nothing