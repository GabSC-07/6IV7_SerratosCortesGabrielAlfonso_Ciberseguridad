const express = require('express');
const multer = require('multer');
const path = require('path');
const fs = require('fs');

const app = express();
const upload = multer({ dest: 'uploads/' });

const PORT = process.env.PORT || 3000;

app.use(express.static('public'));

// Subir archivo cifrado y servir contenido
app.post('/upload', upload.single('file'), (req, res) => {
  const file = fs.readFileSync(req.file.path, 'utf8');
  fs.unlinkSync(req.file.path);
  res.send(file);
});

app.listen(PORT, () => {
  console.log('Servidor en http://localhost:3000');
});