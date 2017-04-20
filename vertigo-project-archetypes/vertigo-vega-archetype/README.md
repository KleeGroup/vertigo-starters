# focus-api-archetype

Archetype/StarterKit vertigo.io for FocusJS

Archetype installation in your local repository
```
mvn clean install
```

Once the archetype installed, the archetype is usable and the project can be generated:

Vertigo/FocusJS Project initialization:

```
mkdir myProject
cd myProject
```

```
mvn archetype:generate -DarchetypeCatalog=local
```

Choose io.vertigo:focus-api-archetype (focus-api-archetype)
Define groupId, artifactId, version, package, artifactIdUpper, className

```
git clone https://github.com/KleeGroup/focus-starter-kit.git
```

```
mv ${artifactId} api
mv focus-starter-kit ui
```

```
mv api/pomParent.xml pom.xml
mv api/pomUi.xml ui/pom.xml
```

```
cd ui
npm install
```

#Done
