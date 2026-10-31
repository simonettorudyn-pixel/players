# Players

Mod client-side Fabric per **Minecraft Java 1.21.4**.

## Comportamento

- Allarga e abbassa visivamente i modelli di tutti i player: larghezza **1,65x**, altezza **0,88x**, profondità **1,35x**.
- Se è installato **Combat Hitboxes**, allarga e abbassa nello stesso modo anche i suoi riquadri visivi dei player.
- Modifica solo il rendering: le hitbox di gioco, le collisioni e i colpi restano invariati.
- Non modifica mondo, FOV, telecamera o HUD.

Richiede Fabric Loader e Java 21; non richiede Fabric API.

## Compilare

Con Java 21 e Gradle installato:

```sh
gradle build
```

Il JAR viene generato in `build/libs/players-1.0.0.jar`. Copialo nella cartella `mods` di un'installazione Fabric per Minecraft 1.21.4.
