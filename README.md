<h1>Item Bingo Plugin</h1>
for Spigot 1.21.11

<h2>Disclaimer</h2>
Spigot API was used to make this. See https://github.com/SpigotMC/Spigot-API or https://hub.spigotmc.org
Copyright lies with SpigotMC. I only wrote this plugin.

Not affiliated with Mojang.
This comes without any warranty. You are free to use or modify this plugin however you want, however I won´t be responsible for anything. <strong>For more information, see LICENSE</strong>

<h2>What does this plugin do?</h2>

This is for playing a Bingo minigame on your Spigot server.

The Bingo goals are all vanilla items that are obtainable in survival mode. 
To mark an item as found, you either craft it, pick it up or find it in a chest.
The first Team thal collects a full row, column or diagonal of items wins!

<h3>What kind of different items are there?</h3>
<ul>
<li>All vanilla items that are obtainable in survival mode can appear in the bingo card</li>
<li>Creative items like spawn eggs or command blocks don´t appear</li>
<li>Spawners and reinforced deepslate are made obtainable with silk touch contrary to vanilla mc. They can also appear on the bingo card</li>
<li>Potions (normal, lingering, splash) and tipped Arrows with all obtainable potion types</li>
<li>Each armor piece with every possible armor trim variation, <strong> these count as different items as the plain armor without trim</strong></li>
<li>Each enchantable item with every possible combination of enchantments</li>
<li>Ominous bottles, different levels are treated as different items, e.g. an ominous bottle with bad omen 2 is not the same as one with bad omen 5</li>
</ul>
<h3>When does an item count as equal to an item on the bingo card?</h3>
<ul>
<li>Durability is ignored</li>
<li>Stack count is ignored</li>
<li>The item must fulfill at least all properties of the corresponding item on the Bingo card</li>
<li><strong>Example: On the card, there is a diamond chestplate with thorns 1 and protection 3. Then a diamond chestplate with thorns 1, protection 3 and mending would count as the same item, while one with only protection 3 wouldn´t</strong></li>
</ul>
<h3>Can you customize which items can appear on Bingo cards?</h3>
<strong>No, not yet.</strong>
<h2>Gameplay</h2>
<h3>What options do I have when starting a new game?</h3>
<ul>
<li>Bingo card size can be anywhere from 3x3 - 9x9</li>
<li>Team constellation. You choose which players go into which teams. There are no predefined team sizes. Teams don´t necessarily have to be the same size.</li>
<li>Each team gets a synchronized Backpack inventory, its size can be 9-54 slots.</li>
<li>Choose whether all teams get the same Bingo card, or each team gets a separate card with different, randomized items. Latter would mean that different teams have different item goals to collect.</li>
<li>Whether every player gets an enchanted netherite pickaxe</li>
<li>Whether every player gets a crafting table (the crafting table doesn´t need to be placed down, it opens a crafting gui on right click)</li>
<li>Whether keepInventory is turned on</li>
<li>Whether hunger is turned off</li>
</ul>
<h3>Game loop</h3>
<ol>
<li>Set teams. This is done with the /teams command. Let´s say, players named "player1" and "player2" go into team 1, "player3" into team 2. Then do /teams [player1,player2][player3]</li>
<li>Start game and choose settings. This is done with the /start command. <ul><li>Argument 1: card size (3-9)</li>
<li>Argument 2: backpack inventory rows (1-6)</li>
<li>Argument 3: different maps for different teams (true/false)</li>
<li>Argument 4: with pickaxes given to players (true/false)</li>
<li>Argument 5: with crafting tables given to players (true/false)</li>
<li>Argument 6: whether hunger is turned off (true/false)</li>
<li>Argument 7: whether keepInventory is turned on (true/false)</li>
</ul>
Example: /start 5 6 false true true true true. This game will have a 5x5 bingo card, a 6 row backpack inventory, every team will have the same card and the same item goals, players will be given pickaxes and crafting tables, hunger is turned off and keepInventory is on.</li>
<li>The game will finish when</li>
<ul><li>A team has collected a full row, column or diagonal</li>
<li>someone performs the /cancel command</li></ul>
</ol>
<h3>Is there a way to store settings or teams?</h3>
No.
<h3>Is it possible to join a team after a game was started?</h3>
No.
<h3>What if someone leaves/disconnects mid-game?</h3>
The plugin will remember this player and put it back in the right team one it rejoins the server.
<h2>Commands</h2>
<ul>
<li>/teams: Sets the specified teams</li>
<li>/start: starts a new game with specified settings</li>
<li>/cancel: cancels a currently running game</li>
</ul>
<strong>These commands to not require any permission, anyone on the server can execute them, including non-admins and players who don´t participate in a running game.</strong>