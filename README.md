# JavaWikiEditor
text compiler script to make files that are ready to upload

unbolding title scripts
```
python pwb.py replace -newpages:69 -regex -multiline -summary:"Unbolding titles - bot" "(^\|title=)(''')([\w?.\-\s]*)(''')" "\1\3"
```
