@color 02
@title Launch Nox Player Emulator
cd C:\Program Files (x86)\Nox\bin
@echo Launch Nox Player Emulator
START "" "C:\Program Files (x86)\Nox\bin\Nox.exe" 
timeout /t 40 /nobreak
cd C:\Program Files\Android\sdk\platform-tools
timeout /t 5 /nobreak
START "" adb kill-server
timeout /t 2 /nobreak
START "" adb connect 127.0.0.1:62001
@exit