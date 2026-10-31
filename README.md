# Players

Mod client-side Fabric per **Minecraft Java 1.21**.

## Comportamento

- Allarga visivamente il modello di tutti i player a **1,65×** e lo rende più basso con altezza **0,88×**; profondità **1,35×**.
- Con **F3+B**, applica la stessa forma al contorno visivo delle hitbox dei player.
- Hitbox reali, collisioni e colpi restano invariati.
- Non modifica mondo, FOV, telecamera o HUD.

Richiede Fabric Loader e Java 21; non richiede Fabric API.

## Compilare

Con Java 21 e Gradle installato:

```sh
gradle build
```

Il JAR viene generato in `build/libs/players-1.0.0.jar`. Copialo nella cartella `mods` di un'installazione Fabric per Minecraft 1.21.
