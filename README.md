# Players

Mod client-side Fabric per **Minecraft Java 1.21**.

## Comportamento

- Allarga e abbassa visivamente il modello di tutti i player: larghezza **1,65x**, altezza **0,88x**, profondità **1,35x**.
- Con il debug hitbox standard attivato (**F3+B**), scala il riquadro visivo dei player con le stesse proporzioni.
- Hitbox reali, collisioni e colpi restano invariati.
- Non modifica mondo, FOV, telecamera o HUD.

Richiede Fabric Loader e Java 21; non richiede Fabric API.
Il mod Combat Hitboxes 1.0.3 nel profilo richiede Minecraft 1.21.2 o superiore e non è compatibile con Minecraft 1.21.

## Compilare

Con Java 21 e Gradle installato:

```sh
gradle build
```

Il JAR viene generato in `build/libs/players-1.0.0.jar`. Copialo nella cartella `mods` di un'installazione Fabric per Minecraft 1.21.
