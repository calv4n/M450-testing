describe('See All users ', () => {
  it('see a list of Students', () => {
    cy.goToPage()
    cy.get(':nth-child(1) > .btn').click()
    cy.get('app-student-list > .card > .card-body').contains("Yves")
  })
})

describe('Add a new Student', () => {
  it('Create a new Student and see it on the homepage', () => {
    cy.fixture('data').then((data) => {
      cy.goToPage()
      cy.get(':nth-child(2) > .btn').click()
      //cy.wait(1000)
      cy.get('#name').type(data.name+'{esc}')
      cy.get('#email').type(data.email+'{esc}')
      cy.get('form.ng-dirty > .btn').click()
      cy.get('app-student-list > .card > .card-body').contains(data.name)
    })
  })
})
