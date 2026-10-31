# Players

Mod client-side Fabric per **Minecraft Java 1.21**.

## Comportamento

- Scala il modello visibile di tutti i player per corrispondere al riquadro della foto di riferimento: circa **9 × 15 cm** su uno schermo da **70 × 40 cm**, con lo screenshot a schermo intero.
- Con **F3+B**, ingrandisce proporzionalmente il contorno visivo della hitbox dei player per raggiungere quella misura di riferimento.
- Hitbox reali, collisioni e colpi restano invariati.
- Non modifica mondo, FOV, telecamera o HUD.

Le misure in centimetri sono una calibrazione visiva per lo screenshot di riferimento; distanza dal player, risoluzione e dimensioni dello schermo cambiano la misura fisica apparente in gioco.

Richiede Fabric Loader e Java 21; non richiede Fabric API.

## Compilare

Con Java 21 e Gradle installato:

```sh
gradle build
```

Il JAR viene generato in `build/libs/players-1.0.0.jar`. Copialo nella cartella `mods` di un'installazione Fabric per Minecraft 1.21.
