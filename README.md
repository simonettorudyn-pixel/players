# Players

Mod client-side Fabric per **Minecraft Java 1.21**.

## Comportamento

- Allarga e abbassa visivamente il modello di tutti i player: larghezza **1,65x**, altezza **0,88x**, profondità **1,35x**.
- Il modello può sporgere oltre il riquadro hitbox mostrato negli screenshot. Le dimensioni in centimetri sono riferimenti per quella specifica inquadratura; cambiano con la distanza dalla telecamera.
- La trasformazione riguarda solo il rendering: hitbox, collisioni e dimensioni delle entità restano invariate.
- Non modifica mondo, FOV, telecamera o HUD.

Richiede Fabric Loader e Java 21; non richiede Fabric API.

## Compilare

Con Java 21 e Gradle installato:

```sh
gradle build
```

Il JAR viene generato in `build/libs/players-1.0.0.jar`. Copialo nella cartella `mods` di un'installazione Fabric per Minecraft 1.21.
