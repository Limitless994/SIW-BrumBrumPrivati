package model;

public class DettagliRiepilogo {

		private String targa;
		private String marca;
		private String modello;
		private String categoria;
		private String colore;
		private String km;
		private String alimentazione;
		private String cambio;
		private String immagine;
		private String prezzovendita;
		private String prezzonoleggio;
		private String nome;
		private String cognome;
		private String indirizzo;
		private String pagamento;
		private String email;

		public String getNome() {
			return nome;
		}


		public void setNome(String nome) {
			this.nome = nome;
		}


		public String getCognome() {
			return cognome;
		}


		public void setCognome(String cognome) {
			this.cognome = cognome;
		}


		public String getIndirizzo() {
			return indirizzo;
		}


		public void setIndirizzo(String indirizzo) {
			this.indirizzo = indirizzo;
		}


		public String getPagamento() {
			return pagamento;
		}


		public void setPagamento(String pagamento) {
			this.pagamento = pagamento;
		}


		public String getEmail() {
			return email;
		}


		public void setEmail(String email) {
			this.email = email;
		}


		public String getTarga() {
			return targa;
		}


		public void setTarga(String targa) {
			this.targa = targa;
		}


		public String getMarca() {
			return marca;
		}


		public void setMarca(String marca) {
			this.marca = marca;
		}


		public String getCategoria() {
			return categoria;
		}


		public void setCategoria(String categoria) {
			this.categoria = categoria;
		}


		public String getColore() {
			return colore;
		}


		public void setColore(String colore) {
			this.colore = colore;
		}


		public String getKm() {
			return km;
		}


		public void setKm(String km) {
			this.km = km;
		}


		public String getAlimentazione() {
			return alimentazione;
		}


		public void setAlimentazione(String alimentazione) {
			this.alimentazione = alimentazione;
		}


		public String getCambio() {
			return cambio;
		}


		public void setCambio(String cambio) {
			this.cambio = cambio;
		}


		public String getImmagine() {
			return immagine;
		}


		public void setImmagine(String immagine) {
			this.immagine = immagine;
		}

		public String getModello() {
			return modello;
		}


		public void setModello(String modello) {
			this.modello = modello;
		}

		public String getPrezzovendita() {
			return prezzovendita;
		}


		public void setPrezzovendita(String prezzovendita) {
			this.prezzovendita = prezzovendita;
		}


		public String getPrezzonoleggio() {
			return prezzonoleggio;
		}


		public void setPrezzonoleggio(String prezzonoleggio) {
			this.prezzonoleggio = prezzonoleggio;
		}


		public DettagliRiepilogo(String targa, String marca, String modello, String categoria, String colore, String km,
				String alimentazione, String cambio, String immagine, String prezzovendita, String prezzonoleggio,
				String nome, String cognome, String indirizzo, String pagamento, String email) {
			super();
			this.targa = targa;
			this.marca = marca;
			this.modello = modello;
			this.categoria = categoria;
			this.colore = colore;
			this.km = km;
			this.alimentazione = alimentazione;
			this.cambio = cambio;
			this.immagine = immagine;
			this.prezzovendita = prezzovendita;
			this.prezzonoleggio = prezzonoleggio;
			this.nome = nome;
			this.cognome = cognome;
			this.indirizzo = indirizzo;
			this.pagamento = pagamento;
			this.email = email;
		}


		@Override
		public String toString() {
			return "DettagliRiepilogo [targa=" + targa + ", marca=" + marca + ", modello=" + modello + ", categoria="
					+ categoria + ", colore=" + colore + ", km=" + km + ", alimentazione=" + alimentazione + ", cambio="
					+ cambio + ", immagine=" + immagine + ", prezzovendita=" + prezzovendita + ", prezzonoleggio="
					+ prezzonoleggio + ", nome=" + nome + ", cognome=" + cognome + ", indirizzo=" + indirizzo
					+ ", pagamento=" + pagamento + ", email=" + email + "]";
		}




	}
