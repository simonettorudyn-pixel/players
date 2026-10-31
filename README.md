# Players

Mod client-side Fabric per **Minecraft Java 1.21**.

## Comportamento

- Imposta a **1,50** il rapporto orizzontale della proiezione del mondo, in modo simile alla mod VisualRatio.
- Compensa il rendering di tutti i player per mantenerne inalterate le dimensioni visive rispetto alla visuale originale.
- Non cambia FOV, telecamera, HUD, movimento, collisioni o hitbox. Non modifica le entità nel mondo.

Richiede Fabric Loader e Java 21; non richiede Fabric API.

## Compilare

Con Java 21 e Gradle installato:

```sh
gradle build
```

Il JAR viene generato in `build/libs/players-1.0.0.jar`. Copialo nella cartella `mods` di un'installazione Fabric per Minecraft 1.21.
