# Players

Mod client-side Fabric per **Minecraft Java 1.21**.

## Comportamento

- Riduce un po' il modello visibile dei player: larghezza **1,40×**, altezza **0,78×**, profondità **1,20×**.
- Con **F3+B**, ingrandisce di più il contorno visivo delle hitbox dei player: larghezza **2,00×**, altezza **1,15×**, profondità **1,70×**.
- Hitbox reali, collisioni e colpi restano invariati.
- Non modifica mondo, FOV, telecamera o HUD.

Richiede Fabric Loader e Java 21; non richiede Fabric API.

## Compilare

Con Java 21 e Gradle installato:

```sh
gradle build
```

Il JAR viene generato in `build/libs/players-1.0.0.jar`. Copialo nella cartella `mods` di un'installazione Fabric per Minecraft 1.21.
