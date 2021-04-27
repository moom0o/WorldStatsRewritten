[![Discord Mine](https://img.shields.io/discord/807380182729228298?label=chat&logo=discord&logoColor=white)](https://discord.gg/JtKJF3Jgwm)

# WorldStatsRewritten

### A better rewrite of the old Worldstats plugin that is more lightweight and doesn't cause lag.

[![bstats](https://bstats.org/signatures/bukkit/WorldStatsRewritten.svg)](https://bstats.org/plugin/bukkit/WorldStatsRewritten/10319)

# World time

For the plugin to calculate world time please convert the date of your map start to epoch milliseconds and set the time
setting in config.yml to the epoch.

# PlaceholderAPI

* %worldstats_filesize% - Get the cached file size.
* %worldstats_players% - Get the cached unique players amount.
* %worldstats_days% - Get how old the map is in DAYS

Additionally, all placeholders are supported in the /stats message.

# Support

Join my support discord if you have any issues.
<br>
Discord: https://discord.gg/HfuyuqhXdb

# Config

<details>
  <summary>config.yml</summary>

```yml
# supports placeholderapi
message:
  - '&7-----------------------------------------------------'
  - '&6%totalPlayers% &3player(s) have spawned at least once in the world. '
  - '&3The World is &6%years% years, %months% months and %days% days old &3and has a file
    size of &6%fileSize% GB'
  - '&7-----------------------------------------------------'
filesizeupdate_in_ticks: 72000
Worlds:
  - "./world/region"
  - "./world_nether/DIM-1/region"
  - "./world_the_end/DIM1/region"
time: 0
```

</details>
