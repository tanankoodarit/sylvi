# sylvi
front

# Development mode

To start the Figwheel compiler, navigate to the project folder and run the following command in the terminal:

```
lein figwheel
```

Or in repl:<br/>
```
(use 'figwheel-sidecar.repl-api)
```

```
(start-figwheel!)
```

Figwheel will automatically push cljs changes to the browser.
Once Figwheel starts up, you should be able to open the `public/index.html` page in the browser and see the changes refresh live. Alternatively, you could run `python -m SimpleHTTPServer` in the `public` folder.

## Browser
http://localhost:3449

# Building for release

```
lein clean
lein release
```
