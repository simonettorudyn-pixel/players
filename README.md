# Players

Mod client-side Fabric per **Minecraft Java 1.21**.

## Comportamento

- Riduce un po' il modello visibile dei player: larghezza **1,25×**, altezza **0,72×**, profondità **1,00×**.
- Con **F3+B**, ingrandisce nettamente di più il contorno visivo delle hitbox: larghezza **2,50×**, altezza **1,25×**, profondità **2,00×**.
- Hitbox reali, collisioni e colpi restano invariati.
- Non modifica mondo, FOV, telecamera o HUD.

Richiede Fabric Loader e Java 21; non richiede Fabric API.

## Compilare

Con Java 21 e Gradle installato:

```sh
gradle build
```

Il JAR viene generato in `build/libs/players-1.0.0.jar`. Copialo nella cartella `mods` di un'installazione Fabric per Minecraft 1.21.
