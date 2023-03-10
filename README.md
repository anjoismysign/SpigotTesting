# SpigotTesting
https://www.spigotmc.org/threads/loading-only-one-part-of-the-config.595537/

Research I made while helping an unpolite fellow programmer.

The issue is that subject needs to store objects (ConfigurationSerializable) inside config.yml
This is messy and multiple people told them to use separate YAML files.
Basically, each time JavaPlugin#reloadConfig is called will deserialize all ConfigurationSerializable
inside config.yml

Solution is simple as we stated before.
BlobLib for example provides you with asynchronous YAML deserialization.
