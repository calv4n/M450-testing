import { Component, OnInit } from '@angular/core';
import { Student } from '../model/student';
import { StudentService } from '../service/student.service';

@Component({
  selector: 'app-student-list',
  templateUrl: './student-list.component.html',
  styleUrls: ['./student-list.component.css']
})
export class StudentListComponent implements OnInit {

  students: Student[] = []; // Liste aller Studenten
  deleteId: number | null = null; // ID, die gelöscht werden soll

  constructor(private studentService: StudentService) { }

  ngOnInit() {
    this.loadStudents(); // Studentenliste laden
  }

  // Methode zum Laden aller Studenten
  loadStudents(): void {
    this.studentService.findAll().subscribe(data => {
      this.students = data;
    });
  }

  // Methode zum Löschen eines Studenten
  deleteStudent(): void {
    if (this.deleteId === null || this.deleteId <= 0) {
      alert('Bitte eine gültige ID eingeben!');
      return;
    }

    this.studentService.delete(this.deleteId).subscribe({
      next: () => {
        alert(`Student mit ID ${this.deleteId} erfolgreich gelöscht.`);
        this.loadStudents(); // Aktualisiere die Liste nach dem Löschen
        this.deleteId = null; // Eingabefeld zurücksetzen
      },
      error: (err) => {
        console.error('Fehler beim Löschen des Studenten:', err);
        alert('Löschen fehlgeschlagen. Bitte versuchen Sie es erneut.');
      }
    });
  }
}
