@color 02
@title Launch Screen Recorder Application
cd C:\ffmpeg\bin
@echo Launch Screen Recorder Application
::.\ffmpeg.exe -f gdigrab -i title=TeamViewer C:\Eclipse\workspace\BlueStacks.BA.Poc\src\test\resources\screenVideoCapture\baScreenVideoCapture_%date:~6,8%%date:~3,2%%date:~0,2%_%time:~0,2%%time:~3,2%%time:~6,2%.avi
::.\ffmpeg.exe -f gdigrab -i title=BlueStacks C:\Eclipse\workspace\BlueStacks.BA.Poc\src\test\resources\screenVideoCapture\baScreenVideoCapture_%date:~6,8%%date:~3,2%%date:~0,2%_%time:~0,2%%time:~3,2%%time:~6,2%.avi
::.\ffmpeg.exe -f gdigrab -i title=BlueStacks C:\Eclipse\workspace\BlueStacks.BA.Poc\src\test\resources\screenVideoCapture\baScreenVideoCapture_%date:~6,8%%date:~3,2%%date:~0,2%_%time:~0,2%%time:~3,2%%time:~6,2%.mp4
.\ffmpeg.exe -f dshow -i video="UScreenCapture" C:\Eclipse\workspace\BlueStacks.BA.Poc\src\test\resources\screenVideoCapture\baScreenVideoCapture_%date:~6,8%%date:~3,2%%date:~0,2%_%time:~0,2%%time:~3,2%%time:~6,2%.mp4
::.\ffmpeg.exe -f dshow -i video="UScreenCapture" C:\Eclipse\workspace\BlueStacks.BA.Poc\src\test\resources\screenVideoCapture\baScreenVideoCapture_%date:~6,8%%date:~3,2%%date:~0,2%_%time:~0,2%%time:~3,2%%time:~6,2%.avi
::.\ffmpeg.exe -f dshow -i video="screen-capture-recorder" C:\Eclipse\workspace\BlueStacks.BA.Poc\src\test\resources\screenVideoCapture\baScreenVideoCapture_%date:~6,8%%date:~3,2%%date:~0,2%_%time:~0,2%%time:~3,2%%time:~6,2%.mp4
::.\ffmpeg.exe -f gdigrab -framerate 30 -i title=BlueStacks C:\Eclipse\workspace\BlueStacks.BA.Poc\src\test\resources\screenVideoCapture\baScreenVideoCapture_%date:~6,8%%date:~3,2%%date:~0,2%_%time:~0,2%%time:~3,2%%time:~6,2%.mp4