const xhr1 = new XMLHttpRequest()
xhr1.onreadystatechange = function() {
	if (xhr1.readyState === 4 && xhr1.status === 200) {
		console.log(xhr1.responseText)
		const res = JSON.parse(xhr1.response)

		if(res.length) {
			res.forEach(function(product) {
				appendOneElementToCart(product)
			})
		} else {
			appendOneElementToCart(res)
		}

		function appendOneElementToCart(res) {
			const body = document.querySelector('.cart')

			const cartItemContainer = document.createElement('div')
			cartItemContainer.classList.add('cartContainer')

			appendElement(cartItemContainer, createElement('h2', res.name))
			appendElement(cartItemContainer, createElement('p', res.quantity))
			
			appendElement(body, cartItemContainer)

		}

		function createElement(elem, textValue) {
			const newElem = document.createElement(elem)
			newElem.innerText = textValue

			return newElem
		}

		function appendElement(parent, child) {
			parent.appendChild(child)
		}

		function showAllPropsInObject(object) {
			for (prop in res) {
				console.log(`${prop} ${res[prop]}`)
			}
		}

		console.log(res)
	}
}

xhr1.open('GET', 'http://localhost:8080/cart/1', true)
xhr1.send()