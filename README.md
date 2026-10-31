# Players

Piccola mod client-side Fabric per **Minecraft Java 1.21**. Allarga il modello renderizzato del tuo player locale e lo rende leggermente più basso, ispirandosi allo screenshot di riferimento.

## Cosa cambia

- Modifica solo il rendering del modello del player locale: larghezza `1.65x`, altezza `0.88x`, profondità `1.35x`.
- Non cambia FOV, telecamera, mondo, HUD, altri giocatori, movimento, collisioni o hitbox.
- Non richiede Fabric API; richiede Fabric Loader e Java 21.

## Compilare

Con Java 21 e Gradle installato, dalla cartella del progetto esegui:

```sh
gradle build
```

Il JAR viene generato in `build/libs/players-1.0.0.jar`. Copialo nella cartella `mods` di un'installazione Fabric per Minecraft 1.21.
