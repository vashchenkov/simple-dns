rem d:\programming\java\jdk-9\bin\javac --module-path libs/ -d mods/ru.gubber.mus_sync_app src/ru.gubber.mus_sync_app/module-info.java src/ru.gubber.mus_sync_app/ru/gubber/mus_sync_app/MusicSyncApp.java
dir /s/b *.java > sources.txt
d:\programming\java\jdk-9\bin\javac -d mods/ru.gubber.simple_dns src/ru.gubber.simple_dns/module-info.java @sources.txt